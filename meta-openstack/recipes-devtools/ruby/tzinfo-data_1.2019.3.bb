SUMMARY = "TZInfo::Data - Timezone Data for TZInfo"
HOMEPAGE = "https://tzinfo.github.io/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c326926e773a4e99e89820f5d8a0966f"

SRCREV = "74d5a2529d585e1d1ab47b6bbb2449cba29f6907"

SRC_URI = "git://github.com/tzinfo/tzinfo-data.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit ruby

FILES:${PN} += "${libdir}/*"
