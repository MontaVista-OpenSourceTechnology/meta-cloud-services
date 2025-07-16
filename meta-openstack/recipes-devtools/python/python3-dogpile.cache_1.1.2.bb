DESCRIPTION = "Python Dogpile Cache: A caching front-end based on the Dogpile lock"
HOMEPAGE = "https://pypi.python.org/pypi/dogpile.cache"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6d830a549d9d8c25362346e0f8fbba53"

SRC_URI[md5sum] = "fb9bea726156560d03890599c4cd92e0"
SRC_URI[sha256sum] = "2134464672a3deb7ef1366a8691726686d8c62540e4208f1a40c9aaa1a0b6a45"

inherit setuptools3 pypi

RDEPENDS:${PN} += " \
	python3-decorator \
	python3-logging \
	python3-numbers \
	python3-stevedore \
"

