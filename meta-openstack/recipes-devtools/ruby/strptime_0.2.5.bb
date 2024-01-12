SUMMARY = "a fast strpitme engine"
HOMEPAGE = "https://github.com/nurse/strptime"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f19575067ffc5f1ddc02c74eeef9904f"

SRCREV = "1583aaa510cae4660907b22c8262ab31b1eb1864"

SRC_URI = "git://github.com/nurse/strptime.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "bash"

inherit ruby

FILES:${PN} += "${libdir}/*"
