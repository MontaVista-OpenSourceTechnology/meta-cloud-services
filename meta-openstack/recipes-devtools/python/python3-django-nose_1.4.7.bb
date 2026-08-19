#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "Django test runner using nose"
HOMEPAGE = "https://github.com/django-nose/django-nose"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7f88f52f66738ec7259424ce46e855c2"

SRC_URI[md5sum] = "fe386c6e218b0f7b353494329c380a79"
SRC_URI[sha256sum] = "a4885cd002d65fd2de96e2bb2563ef477c3fbe207009360c015fca5c3b5561b7"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        "

RDEPENDS:${PN} += " \
        python3-django \
        python3-nose-exclude \
        python3-misc \
        "

