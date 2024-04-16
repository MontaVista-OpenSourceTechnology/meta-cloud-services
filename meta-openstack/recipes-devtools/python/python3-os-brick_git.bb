DESCRIPTION = "OpenStack Cinder brick library for managing local volume attaches"
HOMEPAGE = "https://github.com/openstack/os-brick"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI = "\
	git://github.com/openstack/os-brick.git;branch=stable/victoria;protocol=https \
	"
SRCREV = "f0cf77672fed70f20896c23015cb50341f311f38"

PV = "4.0.1+git${SRCPV}"
S = "${WORKDIR}/git"

inherit setuptools3

FILES:${PN} += "${datadir}/etc/*"

DEPENDS += " \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        python3-pbr \
        python3-babel \
        python3-eventlet \
        python3-oslo.concurrency \
        python3-oslo.log \
        python3-oslo.serialization \
        python3-oslo.i18n \
        python3-oslo.privsep \
        python3-oslo.service \
        python3-oslo.utils \
        python3-requests \
        python3-retrying \
        python3-six \
        python3-os-win \
"
