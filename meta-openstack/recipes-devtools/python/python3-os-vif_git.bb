DESCRIPTION = "OpenStack integration library between network and compute providers."
HOMEPAGE = "https://github.com/openstack/os-vif"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI = "\
	git://github.com/openstack/os-vif.git;branch=master;protocol=https \
	"

PV = "2.2.0+git${SRCPV}"
SRCREV = "d7928102d69dadf653c9f734e5cf8fd504335849"

inherit setuptools3

DEPENDS += " \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-netaddr \
        python3-oslo.concurrency \
        python3-oslo.config \
        python3-oslo.log \
        python3-oslo.i18n \
        python3-oslo.privsep \
        python3-six \
        python3-stevedore \
        "
	
