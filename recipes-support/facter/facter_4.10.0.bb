SUMMARY = "Facter gathers basic facts about nodes (systems)"
HOMEPAGE = "http://puppetlabs.com/facter"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
    http://downloads.puppetlabs.com/facter/facter-${PV}.tar.gz \
    file://facter.gemspec \
"
SRC_URI[md5sum] = "e2d0f3c6307b54ffbf2cc018d11f2fb2"
SRC_URI[sha256sum] = "8da6ceccafc945ac529051b19fa21fca9a20092545b00fbff5c14923e0324d79"

inherit ruby

DEPENDS += " \
        ruby \
"

RUBY_INSTALL_GEMS = "facter-4.10.0.gem"
RUBY_GEM_VERSION = "3.3.0"

do_compile:prepend() {
    cp ${UNPACKDIR}/facter.gemspec ${S}
}
