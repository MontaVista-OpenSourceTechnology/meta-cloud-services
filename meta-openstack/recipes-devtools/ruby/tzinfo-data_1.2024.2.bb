SUMMARY = "TZInfo::Data - Timezone Data for TZInfo"
HOMEPAGE = "https://tzinfo.github.io/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3ed88ee248e60bdf8512a6469f28c191"

SRCREV = "7645b92dccf2c13e3958fedff7b0d105e1c6bb72"

SRC_URI = "git://github.com/tzinfo/tzinfo-data.git;protocol=https;branch=master"

inherit ruby

FILES:${PN} += "${libdir}/*"
