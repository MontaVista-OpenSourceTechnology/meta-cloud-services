DESCRIPTION = "Unified SDK for OpenStack"
HOMEPAGE = "https://github.com/openstack/python-openstacksdk"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI = " \
        git://github.com/openstack/python-openstacksdk.git;branch=master;protocol=https \
        "

PV = "0.52.0+git${SRCPV}"
SRCREV = "e169c495de39a2d97ef1d8bb7894b18e4ef268dd"

inherit setuptools3

DEPENDS += "\
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
	"

RDEPENDS:${PN} += " \
        python3-pbr \
        bash \
        python3-jsonpatch \
        python3-six \
        python3-stevedore \
        python3-os-client-config \
        python3-keystoneauth1 \
        python3-deprecation \
        python3-os-service-types \
        python3-munch \
        python3-jmespath \
        python3-netifaces \
        python3-decorator \
        python3-dogpile.cache \
        "
