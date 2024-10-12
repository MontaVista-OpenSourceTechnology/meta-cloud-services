SUMMARY = "simple callback-based HTTP request/response parser"
HOMEPAGE = "https://rubygems.org/gems/http_parser.rb"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE-MIT;md5=157efc3766c6d07d3d857ebbab43351a"

SRCREV = "71ecce2a498f87ba83ea3d77322a001132610a6e"

SRC_URI = "gitsm://github.com/tmm1/http_parser.rb.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

# Bitbake doesn't allow the underscore in file name, hence the dash
SRCNAME = "http_parser.rb"

# DEPENDS = "git"

inherit rubyv2

GEM_NAME = "http-parser.rb"
GEM_SPEC_FILE = "http_parser.rb.gemspec"

# # Download the submodules
# do_configure:prepend() {
# 	cd ${WORKDIR}/git
# 	git submodule update --init --recursive
# }

FILES:${PN} += "${libdir}/*"
