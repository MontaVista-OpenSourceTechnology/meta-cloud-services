DESCRIPTION = "cssselect parses CSS3 Selectors and translates them to XPath 1.0"
HOMEPAGE = "http://packages.python.org/cssselect/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=952026b3fd2f625f2a3c0aa21da2493d"

SRC_URI[md5sum] = "fa57704c1cb66cc8e537b782bd6b227e"
SRC_URI[sha256sum] = "f95f8dedd925fd8f54edb3d2dfb44c190d9d18512377d3c1e2388d16126879bc"

inherit setuptools3 pypi

# DEPENDS_default: python-pip

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

# RDEPENDS:default: 
RDEPENDS:${PN} += " \
        "
