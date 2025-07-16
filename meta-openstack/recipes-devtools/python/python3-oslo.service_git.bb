DESCRIPTION = "oslo.service library"
HOMEPAGE = "https://wiki.openstack.org/wiki/Oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "1.25.2"
SRCREV = "8481ce67951aa1b44203c03639b79e06f65bd8bc"

SRCNAME = "oslo.service"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/pike;protocol=https"

inherit setuptools3

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-webob \
        python3-eventlet \
        python3-greenlet \
        python3-monotonic \
        python3-oslo.utils \
        python3-oslo.concurrency \
        python3-oslo.config \
        python3-oslo.log \
        python3-six \
        python3-oslo.i18n \
        python3-pastedeploy \
        python3-paste \
        python3-routes \
        python3-dnspython \
        "
	
