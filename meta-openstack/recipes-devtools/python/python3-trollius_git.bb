DESCRIPTION = "Port of the Tulip project (asyncio module, PEP 3156) on Python 2"
HOMEPAGE = "https://github.com/haypo/trollius"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f7bb094c7232b058c7e9f2e431f389c"

PV = "3.4.3+git${SRCPV}"
SRCREV = "7b2d8abfce1d7ef18ef516f9b1b7032172630375"

SRCNAME = "trollius"
SRC_URI = "git://github.com/haypo/${SRCNAME}.git;branch=trollius;protocol=https"

inherit setuptools3

DEPENDS += " \
        python3-pip \
        "

RDEPENDS:${PN} += " \
        "
