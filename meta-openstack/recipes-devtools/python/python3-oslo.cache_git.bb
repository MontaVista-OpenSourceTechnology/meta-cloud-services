DESCRIPTION = "An oslo.config enabled dogpile.cache"
HOMEPAGE = "https://github.com/openstack/oslo.cache"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "2.6.1+git${SRCPV}"
SRCREV = "df075b2465195de53e42897e7d9be6c6c375ce5e"

SRCNAME = "oslo.cache"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

inherit setuptools3

# DEPENDS_default: python-pip

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
        python3-dogpile.cache \
        python3-six \
        python3-oslo.config \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-oslo.utils \
        "
