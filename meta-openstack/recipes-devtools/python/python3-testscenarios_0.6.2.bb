DESCRIPTION = "testscenarios: a pyunit extension for dependency injection"
HOMEPAGE = "https://pypi.python.org/pypi/testscenarios"
SECTION = "devel/python"
LICENSE = "Apache-2.0 OR BSD-3-Clause"
LIC_FILES_CHKSUM = "file://BSD;md5=0805e4f024d089a52dca0671a65b8b66 \
                    file://Apache-2.0;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "ab5ae8cd550e11ea978151981e7a8ecac329b7b22e4dec706b1e6fe213f463e7"

inherit python_hatchling pypi

DEPENDS += "\
    ${PYTHON_PN}-pbr \
    ${PYTHON_PN}-hatch-vcs-native \
    "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
    ${PYTHON_PN}-pbr-native \
    "

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-testtools \
    ${PYTHON_PN}-pbr \
    "
