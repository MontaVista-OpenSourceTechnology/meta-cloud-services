SUMMARY = 'Simple evented I/O for Ruby (but please check out Celluloid::IO instead)'
HOMEPAGE = 'http://coolio.github.com'

LICENSE = 'MIT'
LIC_FILES_CHKSUM = 'file://LICENSE;md5=a5e7701a63eb0a961f98cd10475129b9'

SRCREV = "6f85a2a104488e5c7cb128b9a83058d28ba16d37"

SRC_URI = 'git://github.com/tarcieri/cool.io.git;protocol=https;branch=main'

S = '${WORKDIR}/git'

inherit rubyv2

GEM_NAME = "cool.io"
GEM_SPEC_FILE = "cool.io.gemspec"

FILES:${PN} += "${libdir}/*"
