DESCRIPTION = "Tools for using Babel with Django"
HOMEPAGE = "https://github.com/python-babel/django-babel"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=5ae97ab65116b8d7890c59de57577b46"

inherit setuptools3 pypi

SRC_URI[md5sum] = "a5483952426d1cd749e7204902b34d63"
SRC_URI[sha256sum] = "1e621b198e1f98ae4f93e43463cf78cbedbace475eb6e0853ba1e2567f3b8119"

DEPENDS += " \
        python3-pip \
        "

RDEPENDS:${PN} += " \
        python3-django \
        python3-babel \
        "

