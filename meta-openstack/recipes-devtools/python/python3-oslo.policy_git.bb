SUMMARY = "Oslo Policy library"
DESCRIPTION = "The Oslo Policy library provides support for RBAC policy enforcement across all OpenStack services."
HOMEPAGE = "https://github.com/openstack/oslo.policy"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "3.3.0+git${SRCPV}"
SRCREV = "cab28649c689067970a51a2f9b329bdd6a0f0501"

SRCNAME = "oslo.policy"
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

RDEPENDS:${PN} += " \
        python3-oslo.config \
        python3-oslo.i18n \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-six \
        python3-pyyaml \
        python3-requests \
"
