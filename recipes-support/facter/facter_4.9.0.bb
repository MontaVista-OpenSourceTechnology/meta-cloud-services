SUMMARY = "Facter gathers basic facts about nodes (systems)"
HOMEPAGE = "http://puppetlabs.com/facter"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
    http://downloads.puppetlabs.com/facter/facter-${PV}.tar.gz \
    file://facter.gemspec \
"
SRC_URI[md5sum] = "676406153803d3d79d3d7149280a4bcd"
SRC_URI[sha256sum] = "2cacccc9d7745953014bffe3b2f46468b5022026765751519d2659551aa55dc8"

inherit ruby

DEPENDS += " \
        ruby \
"

RUBY_INSTALL_GEMS = "facter-4.10.0.gem"
RUBY_GEM_VERSION = "3.3.0"

do_compile:prepend() {
    cp ${UNPACKDIR}/facter.gemspec ${S}
}
