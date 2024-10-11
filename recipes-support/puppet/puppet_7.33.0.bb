SUMMARY = "Open source Puppet is a configuration management system"
HOMEPAGE = "https://puppetlabs.com/puppet/puppet-open-source"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=72bcf758cb771bfde198d175d9e48429"

SRC_URI = " \
    https://downloads.puppetlabs.com/puppet/puppet-${PV}.tar.gz \
    file://add_puppet_gemspec.patch \
    file://puppet.conf \
    file://puppet.init \
    file://puppet.service \
"
SRC_URI[md5sum] = "82276f0f2547db525af87bf42cf9284f"
SRC_URI[sha256sum] = "a42c691f460eeccdadb175fa7430aa6e366782b2881af9e4b4c8e6e621d7607d"

inherit ruby update-rc.d systemd

DEPENDS += " \
        ruby \
        facter \
"

RDEPENDS:${PN} += " \
        ruby \
        facter \
        ruby-shadow \
        bash \
"

RUBY_INSTALL_GEMS = "puppet-${PV}.gem"

INITSCRIPT_NAME = "${BPN}"
INITSCRIPT_PARAMS = "start 02 5 3 2 . stop 20 0 1 6 ."

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "${BPN}.service"

do_install:append() {
    install -d ${D}${sysconfdir}/puppet
    install -d ${D}${sysconfdir}/puppet/manifests
    install -d ${D}${sysconfdir}/puppet/modules

    install -m 655 ${S}/conf/fileserver.conf ${D}${sysconfdir}/puppet/
    install -m 655 ${S}/conf/environment.conf ${D}${sysconfdir}/puppet/
    install -m 655 ${UNPACKDIR}/puppet.conf ${D}${sysconfdir}/puppet/

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${UNPACKDIR}/puppet.service ${D}${systemd_unitdir}/system

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${UNPACKDIR}/puppet.init ${D}${sysconfdir}/init.d/puppet
}
