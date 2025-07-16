DESCRIPTION = "Oslo Middleware library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "4.1.0+git${SRCPV}"
SRCREV = "7355d905bc0e6b7d8884e290cc26895eed0f7179"

SRCNAME = "oslo.middleware"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/pike;protocol=https"

inherit setuptools3

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "
# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        python3-pbr \
        python3-jinja2 \
        python3-oslo.config \
        python3-oslo.context \
        python3-oslo.i18n \
        python3-oslo.utils \
        python3-six \
        python3-stevedore \
        python3-webob \
        python3-debtcollector \
        python3-statsd \
        python3-monotonic \
        "
