SUMMARY = "TZInfo - Ruby Timezone Library"
HOMEPAGE = "https://tzinfo.github.io/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c326926e773a4e99e89820f5d8a0966f"

SRCREV = "5fc278676efde3c85a788fa85ddabddcd91b846f"

SRC_URI = "git://github.com/tzinfo/tzinfo.git;protocol=https;branch=master"

RDEPENDS:${PN} = "concurrent-ruby"

inherit ruby

FILES:${PN} += "${libdir}/*"
