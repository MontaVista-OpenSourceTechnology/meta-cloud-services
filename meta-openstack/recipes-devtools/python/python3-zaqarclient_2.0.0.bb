DESCRIPTION = "Python Zaqar Client"
HOMEPAGE = "https://github.com/openstack/python-zaqarclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI[sha256sum] = "c64e74d1f69321cb2f33721974c793cac1172eb8397056dfc39a7eb3d9c036de"

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
        python3-requests \
        python3-six \
        python3-stevedore \
        python3-jsonschema \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-oslo.utils \
        python3-keystoneauth1 \
        python3-osc-lib \
	"

PYPI_PACKAGE = "python-zaqarclient"

inherit setuptools3 pypi
