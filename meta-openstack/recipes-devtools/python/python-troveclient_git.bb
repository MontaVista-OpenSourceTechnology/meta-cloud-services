DESCRIPTION = "Trove Client Library for OpenStack Datbase service"
HOMEPAGE = "https://github.com/openstack/python-troveclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "troveclient"

SRC_URI = "\
	git://github.com/openstack/python-troveclient.git;branch=master;protocol=https \
	"

PV = "3.0.0+git${SRCPV}"
SRCREV = "960843de8142db6e61cc4d148a51f55862acbba0"

inherit setuptools3 hosts default_configs rmargparse

USERADD_PACKAGES = "${PN}"

PROVIDES += " \
    ${SRCNAME} \
    ${SRCNAME}-tests \
    "

PACKAGES += " \
    ${SRCNAME} \
    ${SRCNAME}-bin \
    "

PACKAGES:prepend = " \
    ${SRCNAME}-tests \
    "

FILES:${PN} = " \
    ${libdir}/* \
    "

FILES:${SRCNAME}-tests = " \
    ${libdir}/python*/site-packages/${SRCNAME}/tests/* \
    "

ALLOW_EMPTY:${SRCNAME} = "1"
FILES:${SRCNAME} = " \
    "

FILES:${SRCNAME}-bin = " \
    ${bindir}/* \
    "

DEPENDS += " \
        python-pip \
        python-pbr \
        "

RDEPENDS:${PN} += " \
        python-pbr \
        python-prettytable \
        python-requests \
        python-simplejson \
        python-babel \
        python-six \
        python-oslo.utils \
        python-keystoneclient \
	"

RDEPENDS:${SRCNAME}-tests += "python-mock"

RDEPENDS:${SRCNAME} += " \
    ${PN} \
    ${SRCNAME}-bin \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS:${SRCNAME}-bin += " \
    ${PN} \
    "
