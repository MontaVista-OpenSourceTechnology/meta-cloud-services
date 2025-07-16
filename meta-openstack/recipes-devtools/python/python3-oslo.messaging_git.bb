DESCRIPTION = "Oslo Messaging API"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

SRCNAME = "oslo.messaging"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=master;protocol=https"

PV = "12.5.0+git${SRCPV}"
SRCREV = "62e104bdb57714a0754f788795d1b4faf8ebb74d"

inherit setuptools3

# DEPENDS_default: python-pip

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
        bash \
        python3-pbr \
        python3-cachetools \
        python3-futurist \
        python3-oslo.log \
        python3-oslo.utils \
        python3-oslo.serialization \
        python3-oslo.middleware \
        python3-oslo.service \
        python3-oslo.i18n \
        python3-stevedore \
        python3-debtcollector \
        python3-monotonic \
        python3-six \
        python3-webob \
        python3-pyyaml \
        python3-amqp \
        python3-kombu \
        python3-pika \
        python3-pika-pool \
        python3-tenacity \
        "
