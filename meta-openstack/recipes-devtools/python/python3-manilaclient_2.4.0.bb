DESCRIPTION = "Python bindings to the OpenStack Manila API"
HOMEPAGE = "https://github.com/openstack/python-manilaclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9edbbf5857ab51214ef0e8b79069bb07"

SRC_URI[sha256sum] = "e314cce0e1d2b92ff194dfa8e29bc67dd5703799a43abf7c323616ddb50d83c0"

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
        python3-iso8601 \
        python3-oslo.config \
        python3-oslo.log \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-prettytable \
        python3-pycrypto \
        python3-requests \
        python3-simplejson \
        python3-babel \
        python3-six \
        python3-keystoneclient \
	"

PYPI_PACKAGE = "python-manilaclient"

inherit setuptools3 pypi
