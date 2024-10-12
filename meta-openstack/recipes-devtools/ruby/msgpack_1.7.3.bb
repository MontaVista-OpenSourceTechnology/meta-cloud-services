SUMMARY = "MessagePack implementation for Ruby"
HOMEPAGE = "http://msgpack.org/"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

SRCREV = "6bbaa97600430c438675540e1f970d61ce5ccd9e"

SRC_URI = "git://github.com/msgpack/msgpack-ruby.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit rubyv2

GEM_NAME = "msgpack"
GEM_SPEC_FILE = "msgpack"

FILES:${PN} += "${libdir}/*"
