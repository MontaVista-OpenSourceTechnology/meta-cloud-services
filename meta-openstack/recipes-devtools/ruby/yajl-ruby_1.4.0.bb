SUMMARY = "A streaming JSON parsing and encoding library for Ruby (C bindings to yajl)"
HOMEPAGE = "http://rdoc.info/projects/brianmario/yajl-ruby"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7dbd3a9f471247a243db5b62fe091587"

SRCREV = "8830754ac1ca04a0c14f71f6e7c1d240934366fe"

SRC_URI = "git://github.com/brianmario/yajl-ruby.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit rubyv2

GEM_NAME = "yajl-ruby"
GEM_SPEC_FILE = "yajl-ruby.gemspec"

FILES:${PN} += "${libdir}/*"
