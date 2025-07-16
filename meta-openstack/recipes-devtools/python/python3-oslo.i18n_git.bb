DESCRIPTION = "oslo.i18n library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "5.0.1+git${SRCPV}"
SRCREV = "73187bd86903fc87665a829c9a0c714db6aa3022"

SRCNAME = "oslo.i18n"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

inherit setuptools3

# DEPENDS_default: python-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        ${PYTHON_PN}-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        ${PYTHON_PN}-pbr-native \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        ${PYTHON_PN}-babel \
        ${PYTHON_PN}-pbr \
        ${PYTHON_PN}-six \
        "
