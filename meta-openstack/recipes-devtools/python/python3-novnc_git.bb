DESCRIPTION = "This package contains the core python parts of NoVNC"
HOMEPAGE = "https://github.com/kanaka/noVNC"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=99aebbcc36b17df855fad64d4b792bff"

SRCREV = "463c39e4af98ec4106b87bbea17e1605aa4c6180"
PV = "1.3.0"

SRC_URI = "git://github.com/kanaka/noVNC.git;branch=master;protocol=https \
           file://python-distutils.patch"

inherit setuptools3

DEPENDS += " python3-websockify"
