DESCRIPTION = "CLI and python client library for OpenStack Sahara"
HOMEPAGE = "https://launchpad.net/sahara"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

DEPENDS += " \
        ${PYTHON_PN}-pip \
        ${PYTHON_PN}-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        ${PYTHON_PN}-pbr-native \
"

RDEPENDS:${PN} += " \
	${PYTHON_PN}-pbr \
	"

SRCNAME = "saharaclient"

inherit setuptools3

SRC_URI = "git://github.com/openstack/python-saharaclient.git;branch=master;protocol=https"

PV = "3.2.1+git${SRCPV}"
SRCREV = "a9fee07108c432e20a3ca7760541d4fcb4f14811"

