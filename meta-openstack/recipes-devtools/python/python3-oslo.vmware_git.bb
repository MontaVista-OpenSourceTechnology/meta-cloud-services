DESCRIPTION = "oslo.vmware library"
HOMEPAGE = "http://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

PV = "3.4.0+git${SRCPV}"
SRCREV = "32c8d43a20cb6a29f03324fbc2e6cad3bfb5a294"

SRCNAME = "oslo.vmware"
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
        python3-pbr \
        python3-stevedore \
        python3-netaddr \
        python3-six \
        python3-oslo.i18n \
        python3-oslo.utils \
        python3-oslo.concurrency \
        python3-pyyaml \
        python3-lxml \
        python3-suds-jurko \
        python3-eventlet \
        python3-requests \
        python3-urllib3 \
        "
