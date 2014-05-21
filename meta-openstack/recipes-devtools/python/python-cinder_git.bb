DESCRIPTION = "OpenStack Block storage service"
HOMEPAGE = "https://launchpad.net/cinder"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PR = "r0"
SRCNAME = "cinder"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/havana \
    file://cinder.conf \
    file://cinder.init \
    file://cinder-volume \
    file://0001-run_tests-respect-tools-dir.patch \
    file://nfs_setup.sh \
    file://glusterfs_setup.sh \
    file://lvm_iscsi_setup.sh \
    file://add-cinder-volume-types.sh \
    file://fix_cinder_memory_leak.patch \
	"

SRCREV="81259f36f57e91b31009fbd209ea2a07a2ceb213"
PV="2013.2.3+git${SRCPV}"
S = "${WORKDIR}/git"

inherit setuptools update-rc.d identity default_configs

CINDER_BACKUP_BACKEND_DRIVER ?= "cinder.backup.drivers.swift"

do_install_append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    CINDER_CONF_DIR=${D}${sysconfdir}/${SRCNAME}

    sed -e "s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g" \
        ${TEMPLATE_CONF_DIR}/api-paste.ini > ${WORKDIR}/api-paste.ini
    sed -e "s:%SERVICE_USER%:${SRCNAME}:g" -i ${WORKDIR}/api-paste.ini
    sed -e "s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g" \
        -i ${WORKDIR}/api-paste.ini

    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${WORKDIR}/cinder.conf
    sed -e "s:%DB_PASSWORD%:${DB_PASSWORD}:g" -i ${WORKDIR}/cinder.conf
    sed -e "s:%CINDER_BACKUP_BACKEND_DRIVER%:${CINDER_BACKUP_BACKEND_DRIVER}:g" -i ${WORKDIR}/cinder.conf

    install -d ${CINDER_CONF_DIR}
    install -m 600 ${WORKDIR}/cinder.conf ${CINDER_CONF_DIR}/
    install -m 600 ${WORKDIR}/api-paste.ini ${CINDER_CONF_DIR}/
    install -m 600 ${S}/etc/cinder/policy.json ${CINDER_CONF_DIR}/

    install -d ${CINDER_CONF_DIR}/drivers
    install -m 600 ${WORKDIR}/nfs_setup.sh ${CINDER_CONF_DIR}/drivers/
    install -m 600 ${WORKDIR}/glusterfs_setup.sh ${CINDER_CONF_DIR}/drivers/
    install -m 600 ${WORKDIR}/lvm_iscsi_setup.sh ${CINDER_CONF_DIR}/drivers/
    install -m 700 ${WORKDIR}/add-cinder-volume-types.sh ${CINDER_CONF_DIR}/

    install -d ${D}${localstatedir}/log/${SRCNAME}

    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        sed 's:@suffix@:api:' < ${WORKDIR}/cinder.init >${WORKDIR}/cinder-api.init.sh
        install -m 0755 ${WORKDIR}/cinder-api.init.sh ${D}${sysconfdir}/init.d/cinder-api
        sed 's:@suffix@:scheduler:' < ${WORKDIR}/cinder.init >${WORKDIR}/cinder-scheduler.init.sh
        install -m 0755 ${WORKDIR}/cinder-scheduler.init.sh ${D}${sysconfdir}/init.d/cinder-scheduler
        sed 's:@suffix@:backup:' < ${WORKDIR}/cinder.init >${WORKDIR}/cinder-backup.init.sh
        install -m 0755 ${WORKDIR}/cinder-backup.init.sh ${D}${sysconfdir}/init.d/cinder-backup
        install -m 0755 ${WORKDIR}/cinder-volume ${D}${sysconfdir}/init.d/cinder-volume
    fi

    # test setup
    cp run_tests.sh ${CINDER_CONF_DIR}
    cp -r tools ${CINDER_CONF_DIR}
}

CINDER_LVM_VOLUME_BACKING_FILE_SIZE ?= "2G"
CINDER_NFS_VOLUME_SERVERS_DEFAULT = "controller:/etc/cinder/nfs_volumes"
CINDER_NFS_VOLUME_SERVERS ?= "${CINDER_NFS_VOLUME_SERVERS_DEFAULT}"
CINDER_GLUSTERFS_VOLUME_SERVERS_DEFAULT = "controller:/glusterfs_volumes"
CINDER_GLUSTERFS_VOLUME_SERVERS ?= "${CINDER_GLUSTERFS_VOLUME_SERVERS_DEFAULT}"

pkg_postinst_${SRCNAME}-setup () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi

    # This is to make sure postgres is configured and running
    if ! pidof postmaster > /dev/null; then
       /etc/init.d/postgresql-init
       /etc/init.d/postgresql start
    fi

    if [ ! -d /var/log/cinder ]; then
       mkdir /var/log/cinder
    fi

    sudo -u postgres createdb cinder
    cinder-manage db sync

    #Create cinder volume group backing file
    sed 's/%CINDER_LVM_VOLUME_BACKING_FILE_SIZE%/${CINDER_LVM_VOLUME_BACKING_FILE_SIZE}/g' -i /etc/cinder/drivers/lvm_iscsi_setup.sh
    echo "include /etc/cinder/data/volumes/*" >> /etc/tgt/targets.conf

    # Create Cinder nfs_share config file with default nfs server
    if [ ! -f /etc/cinder/nfs_shares ]; then
        echo "${CINDER_NFS_VOLUME_SERVERS}" > /etc/cinder/nfs_shares
        sed 's/\s\+/\n/g' -i /etc/cinder/nfs_shares
        [[ "x${CINDER_NFS_VOLUME_SERVERS}" == "x${CINDER_NFS_VOLUME_SERVERS_DEFAULT}" ]] && is_default="1" || is_default="0"
        /bin/bash /etc/cinder/drivers/nfs_setup.sh ${is_default}
    fi

    # Create Cinder glusterfs_share config file with default glusterfs server
    if [ ! -f /etc/cinder/glusterfs_shares ] && [ -f /usr/sbin/glusterfsd ]; then
        echo "${CINDER_GLUSTERFS_VOLUME_SERVERS}" > /etc/cinder/glusterfs_shares
        sed 's/\s\+/\n/g' -i /etc/cinder/glusterfs_shares
        [[ "x${CINDER_GLUSTERFS_VOLUME_SERVERS}" == "x${CINDER_GLUSTERFS_VOLUME_SERVERS_DEFAULT}" ]] && is_default="1" || is_default="0"
        /bin/bash /etc/cinder/drivers/glusterfs_setup.sh ${is_default}
    fi
}

PACKAGES += "${SRCNAME}-tests ${SRCNAME} ${SRCNAME}-setup ${SRCNAME}-api ${SRCNAME}-volume ${SRCNAME}-scheduler ${SRCNAME}-backup"
ALLOW_EMPTY_${SRCNAME}-setup = "1"

FILES_${PN} = "${libdir}/*"

FILES_${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/run_tests.sh \
                          ${sysconfdir}/${SRCNAME}/tools"

FILES_${SRCNAME}-api = "${bindir}/cinder-api \
    ${sysconfdir}/init.d/cinder-api"

FILES_${SRCNAME}-volume = "${bindir}/cinder-volume \
    ${sysconfdir}/init.d/cinder-volume"

FILES_${SRCNAME}-scheduler = "${bindir}/cinder-scheduler \
    ${sysconfdir}/init.d/cinder-scheduler"

FILES_${SRCNAME}-backup = "${bindir}/cinder-backup \
    ${sysconfdir}/init.d/cinder-backup"

FILES_${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \
    ${localstatedir}/* \
    ${sysconfdir}/${SRCNAME}/drivers/* \
    "

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS_${PN} += "lvm2 \
    python-sqlalchemy \
	python-amqplib \
	python-anyjson \
	python-eventlet \
	python-kombu \
	python-lxml \
	python-routes \
	python-webob \
	python-greenlet \
	python-lockfile \
	python-pastedeploy \
	python-paste \
	python-sqlalchemy-migrate \
	python-stevedore \
	python-suds \
	python-paramiko \
	python-babel \
	python-iso8601 \
	python-setuptools-git \
	python-glanceclient \
	python-keystoneclient \
	python-swiftclient \
	python-cinderclient \
	python-oslo.config \
	python-pbr \
	"

RDEPENDS_${SRCNAME} = "${PN} \
        postgresql postgresql-client python-psycopg2 tgt"

RDEPENDS_${SRCNAME}-api = "${SRCNAME}"
RDEPENDS_${SRCNAME}-volume = "${SRCNAME}"
RDEPENDS_${SRCNAME}-scheduler = "${SRCNAME}"
RDEPENDS_${SRCNAME}-setup = "postgresql sudo ${SRCNAME}"

INITSCRIPT_PACKAGES = "${SRCNAME}-api ${SRCNAME}-volume ${SRCNAME}-scheduler ${SRCNAME}-backup"
INITSCRIPT_NAME_${SRCNAME}-api = "cinder-api"
INITSCRIPT_PARAMS_${SRCNAME}-api = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-volume = "cinder-volume"
INITSCRIPT_PARAMS_${SRCNAME}-volume = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-scheduler = "cinder-scheduler"
INITSCRIPT_PARAMS_${SRCNAME}-scheduler = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
INITSCRIPT_NAME_${SRCNAME}-backup = "cinder-backup"
INITSCRIPT_PARAMS_${SRCNAME}-backup = "${OS_DEFAULT_INITSCRIPT_PARAMS}"
