SUMMARY = "TZInfo - Ruby Timezone Library"
HOMEPAGE = "https://tzinfo.github.io/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c326926e773a4e99e89820f5d8a0966f"

SRCREV = "16b0ff837923401da52325312c51baf9bec700e1"

SRC_URI = "git://github.com/tzinfo/tzinfo.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "concurrent-ruby"

inherit ruby

FILES:${PN} += "${libdir}/*"
