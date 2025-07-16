DESCRIPTION = "Middleware for OpenStack Identity API"
HOMEPAGE = "https://launchpad.net/keystonemiddleware"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a4d0e932ffae1c0131528d30d419c55"

SRCNAME = "keystonemiddleware"

SRC_URI = "\
	git://git.openstack.org/openstack/keystonemiddleware;branch=stable/pike \
	"

PV = "4.17.1+git${SRCPV}"
SRCREV = "6712e8b7125fcbcf891b7e89ecb240798dad28ac"

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
        python3-keystoneauth1 \
        python3-oslo.config \
        python3-oslo.context \
        python3-oslo.i18n \
        python3-oslo.log \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-pbr \
        python3-positional \
        python3-pycadf \
        python3-keystoneclient \
        python3-requests \
        python3-six \
        python3-webob \
        "
