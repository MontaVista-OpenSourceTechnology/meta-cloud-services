SUMMARY = "Use signal to show stacktrace of a Ruby process without restarting it"
HOMEPAGE = "https://github.com/frsyuki/sigdump"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=07d6218b18fb6826f04fd32b4918f085"

SRCREV = "57570f04456560512e4efc1c6fa695b76c17dc0d"

SRC_URI = "git://github.com/frsyuki/sigdump.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit ruby

FILES:${PN} += "${libdir}/*"
