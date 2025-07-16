DESCRIPTION = "oslo.versionedobjects library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "2.3.0+git${SRCPV}"
SRCREV = "8db69628834332ed2df6690135be5d5c1ebd3ca1"

SRCNAME = "oslo.versionedobjects"
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
        python3-six \
        python3-oslo.concurrency \
        python3-oslo.config \
        python3-oslo.context \
        python3-oslo.messaging \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-oslo.log \
        python3-oslo.i18n \
        python3-webob \
        python3-iso8601 \
        python3-netaddr \
       "
