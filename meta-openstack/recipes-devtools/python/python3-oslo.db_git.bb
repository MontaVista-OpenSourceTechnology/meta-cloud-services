DESCRIPTION = "oslo.db library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "8.4.0+git${SRCPV}"
SRCREV = "e42c73343f640eaacb0a76d204eb55c85de4f5d5"

SRCNAME = "oslo.db"
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
       python3-six \
       python3-alembic \
       python3-oslo.config \
       python3-oslo.i18n \
       python3-oslo.utils \
       python3-sqlalchemy \
       python3-sqlalchemy-migrate \
       python3-stevedore \
       python3-pbr \
       python3-debtcollector \
       "
