DESCRIPTION = "OpenStack library for privilege separation"
HOMEPAGE = "https://github.com/openstack/oslo.privsep"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "oslo.privsep"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

PV = "2.4.0+git${SRCPV}"
SRCREV = "512b5d9f6b79b798474d8bb2dac2462b0f705cb9"

inherit setuptools3

DEPENDS += " \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

# RDEPENDS:default:
RDEPENDS:${PN} += " \
        python3-oslo.log \
        python3-oslo.i18n \
        python3-oslo.config \
        python3-oslo.utils \
        python3-cffi \
        python3-eventlet \
        python3-greenlet \
        python3-msgpack \
        "
