SUMMARY = "A simple pluggable Hierarchical Database"
HOMEPAGE = "https://projects.puppetlabs.com/projects/hiera"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cb05cd62f0184c1950374f251caef471"

SRC_URI = " \
    https://downloads.puppetlabs.com/hiera/hiera-${PV}.tar.gz \
    file://hiera.gemspec \
"

SRC_URI[md5sum] = "899ca6294677757ec8c5b6422c0090e2"
SRC_URI[sha256sum] = "1c258f6b290f0884f6b6e892985b58d0dd24f389b42f5911c83f392030c403e1"

inherit ruby

DEPENDS += " \
        ruby \
"

RUBY_INSTALL_GEMS = "hiera-file-1.1.1.gem"

do_compile:prepend() {
    cp ${UNPACKDIR}/hiera.gemspec ${S}
}
