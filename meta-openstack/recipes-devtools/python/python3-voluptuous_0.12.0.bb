DESCRIPTION = "Voluptuous is a Python data validation library"
HOMEPAGE = "https://pypi.python.org/pypi/voluptuous/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9855ba150f2edb00d8e7a41554896ffb"

SRC_URI[md5sum] = "4b628978d320baeee543ee407aefc0b1"
SRC_URI[sha256sum] = "3a4ef294e16f6950c79de4cba88f31092a107e6e3aaa29950b43e2bb9e1bb2dc"

inherit setuptools3 pypi

RDEPENDS:${PN} = " \
        "
