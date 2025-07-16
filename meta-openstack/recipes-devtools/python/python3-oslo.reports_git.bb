DESCRIPTION = "oslo.reports library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "2.2.0+git${SRCPV}"
SRCREV = "bc631aedef131bc45225720e5c8f8e4ca35ff020"

SRCNAME = "oslo.reports"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

inherit setuptools3

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
        python3-jinja2 \
        python3-psutil \
        python3-oslo.i18n \
        python3-oslo.utils \
        python3-oslo.serialization \
        "
