DESCRIPTION = "A pure-Python SNMPv1/v2c/v3 library"
HOMEPAGE = "https://pypi.python.org/pypi/pysnmp"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=b15d29f500f748d1c2a15709769090a8"

SRC_URI[md5sum] = "2222880259daf6e2cb322e938c818276"
SRC_URI[sha256sum] = "0c3dbef2f958caca96071fe5c19de43e9c1b0484ab02a0cf08b190bcee768ba9"

inherit setuptools3 pypi

RDEPENDS:${PN} += "${PYTHON_PN}-pycryptodome \
                   ${PYTHON_PN}-pyasn1 \
"
