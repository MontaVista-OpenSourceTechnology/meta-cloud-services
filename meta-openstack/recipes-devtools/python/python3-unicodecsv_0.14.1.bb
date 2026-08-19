SUMMARY = "Python2's stdlib csv module replacement with unicode support"
HOMEPAGE = "https://github.com/jdunck/python-unicodecsv"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"

LIC_FILES_CHKSUM = "file://PKG-INFO;md5=776dee90d219355b4ffd5c06fda5a39d"

SRC_URI[sha256sum] = "018c08037d48649a0412063ff4eda26eaa81eff1546dbffa51fa5293276ff7fc"

inherit setuptools3 pypi

DEPENDS += " \
	python3-pbr \
	"

RDEPENDS:${PN} += " \
	"

