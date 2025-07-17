DESCRIPTION = "Python client for Mistral REST API"
HOMEPAGE = "https://github.com/openstack/python-mistralclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI[sha256sum] = "b03d52ec860df292192a0face767585633e209ba9297fc71da70d42d6a76aebe"

PYPI_PACKAGE = "python-mistralclient"

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python3-cliff \
        python3-pbr \
        python3-keystoneclient \
        python3-pyyaml \
        python3-requests \
	"

inherit setuptools3 pypi
