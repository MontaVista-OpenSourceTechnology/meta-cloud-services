DESCRIPTION = "Glance stores library"
HOMEPAGE = "https://github.com/openstack/glance_store"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI = "\
	git://git.openstack.org/openstack/glance_store.git;branch=stable/pike \
	"

PV = "0.22.0+git${SRCPV}"
SRCREV = "49c915f498fc8d91c98fcf4e07ceecdcf167fc5a"

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
        bash \
        python3-oslo.config \
        python3-oslo.i18n \
        python3-oslo.serialization \
        python3-oslo.utils \
        python3-oslo.concurrency \
        python3-stevedore \
        python3-eventlet \
        python3-six \
        python3-jsonschema \
        python3-keystoneauth1 \
        python3-keystoneclient \
        python3-requests \
        python3-monotonic \
        python3-dnspython \
        "
