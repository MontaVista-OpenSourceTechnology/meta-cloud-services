DESCRIPTION = "Windows / Hyper-V library for OpenStack projects."
HOMEPAGE = "https://github.com/openstack/os-win"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI = "\
	git://github.com/openstack/os-win.git;branch=master;protocol=https \
	"

PV = "5.1.0+git${SRCPV}"
SRCREV = "066c1c49b52de17217edfdbefe9c96e457ad23d2"

inherit setuptools3

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
        python3-oslo.config \
        python3-oslo.log \
        python3-oslo.utils \
        python3-oslo.i18n \
        python3-greenlet \
        python3-dnspython \
        "
