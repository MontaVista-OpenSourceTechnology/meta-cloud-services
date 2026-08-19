#
# Copyright (C) 2014 Wind River Systems, Inc.
#
DESCRIPTION = "Nose plugin that allows you to easily specify directories to be excluded from testing."
HOMEPAGE = "http://bitbucket.org/kgrandis/nose-exclude"
SECTION = "devel/python"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

SRC_URI[md5sum] = "072f72e782f28a9c42356976f8ec22d9"
SRC_URI[sha256sum] = "f78fa8b41eeb815f0486414f710f1eea0949e346cfb11d59ba6295ed69e84304"

inherit setuptools3 pypi

DEPENDS += " \
        python3-pip \
        "
