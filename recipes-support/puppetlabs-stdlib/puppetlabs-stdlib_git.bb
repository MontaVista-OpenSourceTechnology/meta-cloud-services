SUMMARY = "Puppet Labs Standard Library module"
HOMEPAGE = "https://github.com/puppetlabs/puppetlabs-stdlib"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV = "v9.6.0"
SRCREV = "99aebdd57d665ac7e2ba38ab95f3fbdbc2fb56e0"

SRC_URI = " \
    git://github.com/puppetlabs/puppetlabs-stdlib.git;branch=main;protocol=https \
    file://puppetlabs-stdlib.gemspec \
"

inherit rubyv2

GEM_NAME = "puppetlabs-std"
GEM_SPEC_FILE = "puppetlabs-stdlib.gemspec"

S="${WORKDIR}/git"

DEPENDS += " \
        ruby \
        facter \
"

RDEPENDS:${PN} += " \
        ruby \
        facter \
        puppet \
"

RUBY_INSTALL_GEMS = "puppetlabs-stdlib-${PV}.gem"
