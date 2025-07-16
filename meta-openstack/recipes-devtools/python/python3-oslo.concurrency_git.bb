DESCRIPTION = "oslo.concurrency library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "3.21.2+git${SRCPV}"
SRCREV = "1b25351d1c63e573068fff3d16faca440bbdcabf"

SRCNAME = "oslo.concurrency"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/pike;protocol=https"

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

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        python3-pbr \
        python3-fasteners \
        python3-oslo.config \
        python3-oslo.i18n \
        python3-oslo.utils \
        python3-six \
        "
