DESCRIPTION = "A helper class for handling configuration defaults of packaged apps gracefully."
HOMEPAGE = "http://django-appconf.readthedocs.org/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f34b9b2f6413fd5f91869fa7e992457"

SRC_URI[md5sum] = "da4a355140acaa3eeb236987ab174e9d"
SRC_URI[sha256sum] = "be58deb54a43d77d2e1621fe59f787681376d3cd0b8bd8e4758ef6c3a6453380"

inherit setuptools3 pypi

RDEPENDS:${PN} += " \
	${PYTHON_PN}-django \
	"
