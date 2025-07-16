DESCRIPTION = "OVSDB application library"
HOMEPAGE = "https://github.com/openstack/ovsdbapp"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "ovsdbapp"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/pike;protocol=https"

PV = "0.4.4+git${SRCPV}"
SRCREV = "40064ca2d99389f278028508a17f2e38d6df6f10"

inherit setuptools3

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python3-fixtures \
        python3-ovs \
        python3-pbr \
        "
