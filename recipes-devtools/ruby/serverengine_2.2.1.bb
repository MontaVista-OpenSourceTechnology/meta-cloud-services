SUMMARY = 'A framework to implement robust multiprocess servers like Unicorn'
HOMEPAGE = 'https://rubygems.org/gems/serverengine'

LICENSE = 'Apache-2.0'
LIC_FILES_CHKSUM = 'file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57'

SRCREV = '99d44a0989ab3e64e14ac0367aadf76aa13b3583'

SRC_URI = 'git://github.com/treasure-data/serverengine.git;protocol=https;branch=master'

S = '${WORKDIR}/git'

RDEPENDS:${PN} = "sigdump"

inherit ruby

FILES:${PN} += "${libdir}/*"
