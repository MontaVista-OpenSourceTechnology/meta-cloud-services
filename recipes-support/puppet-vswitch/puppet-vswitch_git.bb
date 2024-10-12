SUMMARY = "Puppet provider for virtual switches."
HOMEPAGE = "https://github.com/openstack/puppet-vswitch"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

PV = "21.1.0"
SRCREV = "43ee6e8d174c2748376f5e166a25c7143747b3b9"

SRC_URI = " \
    git://github.com/openstack/puppet-vswitch.git;branch=master;protocol=https \
    file://puppet-vswitch.gemspec \
"

inherit rubyv2

GEM_NAME = "puppetlabs-std"
GEM_SPEC_FILE = "puppet-vswitch.gemspec"

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

RUBY_INSTALL_GEMS = "puppet-vswitch-${PV}.gem"

do_install:append() {
}
