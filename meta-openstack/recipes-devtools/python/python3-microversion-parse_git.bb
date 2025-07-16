DESCRIPTION = "Simple library for parsing OpenStack microversion headers."
HOMEPAGE = "https://github.com/openstack/microversion-parse"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SRC_URI = "\
	git://github.com/openstack/microversion-parse.git;branch=master;protocol=https \
	"

PV = "1.0.1+git${SRCPV}"
SRCREV = "2c36df6bf33e42c379fbd8228fbe63c77b3714b1"

inherit setuptools3

DEPENDS += " \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        "
	
