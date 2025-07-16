DESCRIPTION = "Client library for Barbican API"
HOMEPAGE = "https://github.com/stackforge/python3-barbicanclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e031cff4528978748f9cc064c6e6fa73"

SRC_URI = "\
	git://github.com/openstack/python-barbicanclient.git;branch=master;protocol=https \
	"

PV = "5.0.1+git${SRCPV}"
SRCREV = "1f0feb30ccd3b19bc23453d85d3266c85fcf04d6"

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
        python3-requests \
        python3-six \
        python3-cliff \
        python3-keystoneauth1 \
        python3-oslo.i18n \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-monotonic \
        "
