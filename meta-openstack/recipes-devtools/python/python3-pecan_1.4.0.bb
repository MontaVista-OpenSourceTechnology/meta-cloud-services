DESCRIPTION = "WSGI object-dispatching web framework"
HOMEPAGE = "https://pypi.python.org/pypi/pecan/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d846877d24bbb3d7a00a985c90378e8c"

SRC_URI[md5sum] = "70667908b648043bc8a3fcb7d1e4d53a"
SRC_URI[sha256sum] = "4b2acd6802a04b59e306d0a6ccf37701d24376f4dc044bbbafba3afdf9d3389a"

inherit python_setuptools_build_meta pypi

RDEPENDS:${PN} = "${PYTHON_PN}-mako \
                  ${PYTHON_PN}-webtest \
                  ${PYTHON_PN}-six \
                  ${PYTHON_PN}-logutils \
                  ${PYTHON_PN}-numbers \
                  ${PYTHON_PN}-backlash \
                  ${PYTHON_PN}-pprint \
"

do_configure:prepend() {
    sed -i "/scripts.*bin\/pecan/d" ${S}/setup.py
}
