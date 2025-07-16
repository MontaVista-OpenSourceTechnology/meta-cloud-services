DESCRIPTION = "Oslo Serialization API"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRCNAME = "oslo.serialization"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/pike;protocol=https"

PV = "2.20.0+git${SRCPV}"
SRCREV = "e56d91427c11a3813a0154d47e804018e580086e"

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
        python3-six \
        python3-oslo.utils \
        python3-pytz \
        python3-msgpack \
        "
