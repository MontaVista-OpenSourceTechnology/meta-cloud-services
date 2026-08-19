DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "52192e631ac39a443fb1abeb52299f22"
SRC_URI[sha256sum] = "f4965fba0a4718d47d470beeb5d6446e3357a62402b16c510b6a2f251e05ac3c"

inherit setuptools3 pypi

FILES:${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS:${PN} = " \
        ${PYTHON_PN}-amqp \
        "
