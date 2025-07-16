DESCRIPTION = "Client library for OpenStack Identity API"
HOMEPAGE = "https://github.com/openstack/python-keystoneclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a4d0e932ffae1c0131528d30d419c55"

SRCNAME = "keystoneclient"

SRC_URI = "file://keystone-api-check.sh"

SRC_URI = "\
        git://github.com/openstack/python-keystoneclient.git;branch=stable/pike;protocol=https \
        file://keystone-api-check.sh \
        "

PV = "4.1.0+git${SRCPV}"
SRCREV = "7ff05baa1fa56f152173651f16fc6fd181291292"

inherit setuptools3 monitor

FILES:${PN}-doc += "${datadir}/keystoneclient" 

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        bash \
        python3-pbr \
        python3-debtcollector \
        python3-keystoneauth1 \
        python3-oslo.config \
        python3-oslo.i18n \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-positional \
        python3-requests \
        python3-six \
        python3-stevedore \
        "

do_install:append() {
	cp -r ${S}/examples ${D}${PYTHON_SITEPACKAGES_DIR}/${SRCNAME}
}

PACKAGES =+ " ${SRCNAME}-tests"

FILES:${SRCNAME}-tests = "${PYTHON_SITEPACKAGES_DIR}/${SRCNAME}/examples \
        "
RDEPENDS:${SRCNAME}-tests += " \
	python3-httpretty \
        bash \
	"

MONITOR_CHECKS_${PN} += "\
	keystone-api-check.sh \
"
