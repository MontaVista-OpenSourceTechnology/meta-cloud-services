DESCRIPTION = "Python client for containers service"
HOMEPAGE = "https://github.com/openstack/python-magnumclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

SRC_URI[sha256sum] = "9734fbaa571fe11f252835878999efe02d4200ca9a5b1d9fe691fd5f4ec81f3b"

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
        python3-babel \
        python3-oslo.config \
        python3-oslo.i18n \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-iso8601 \
        python3-requests \
        python3-keystoneclient \
        python3-pyyaml \
        python3-stevedore \
        python3-six \
	"

PYPI_PACKAGE = "python-magnumclient"

inherit setuptools3 pypi 
