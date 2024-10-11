SUMMARY = "Shadow Password Module"
HOMEPAGE = "https://github.com/apalmblad/ruby-shadow"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eee512aef6667f19c00b841db708cfeb"

PV = "2.5.1"

SRC_URI = "git://github.com/apalmblad/ruby-shadow.git;branch=master;protocol=https \
           file://0001-shadow-update-to-ruby-3.x-str-routines.patch \
           file://extconf.rb"

SRCREV = "f135b3fd52d0a638f2eb9b17a8952a7f0f317688"
S = "${WORKDIR}/git"

inherit ruby

GEM_NAME = "ruby-shadow"
GEM_SPEC_FILE = "ruby-shadow.gemspec"

DEPENDS += " \
        ruby \
        shadow \
"

RDEPENDS:${PN} += " \
        ruby \
"

RUBY_INSTALL_GEMS = "ruby-shadow-${PV}.gem"
FILES:${PN}-dbg += "/usr/lib*/ruby/gems/*/gems/ruby-shadow-${PV}/.debug/shadow.so"

INSANE_SKIP:${PN} += "ldflags textrel"
