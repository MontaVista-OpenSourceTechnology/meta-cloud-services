SUMMARY = "Common testing tools used in the Salt Stack projects"
HOMEPAGE = "https://github.com/saltstack/salt-testing"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f36f1e9e3e30f90180efdf7e40d943e5"

SRC_URI = "git://github.com/saltstack/salt-testing.git;branch=develop;protocol=https \
           file://0001-Add-ptest-output-option-to-test-suite.patch \
           "

SRCREV = "8d21627a4eef316d22cc424deeca16a0ec8472e9"
PV = "2018.9.21+git${SRCPV}"

RDEPENDS:${PN} = "\
                  python3-mock \
                  python3-unittest \
"

inherit setuptools3
