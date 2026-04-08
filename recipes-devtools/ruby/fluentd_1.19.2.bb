SUMMARY = "Fluentdu Open-Source Log Collector"
HOMEPAGE = "https://www.fluentd.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ffc336af228834e68e0a4d38da165f7"

SRCREV = "76841666b4e4aade23f0c100a7e048995f7d52c8"

SRC_URI = "git://github.com/fluent/fluentd.git;protocol=https;branch=v1.19"

RDEPENDS:${PN} = "cool.io http-parser.rb msgpack serverengine sigdump strptime tzinfo tzinfo-data yajl-ruby"

inherit ruby

do_install:append() {
	install -d ${D}/etc/fluent/
	install ${S}/fluent.conf ${D}/etc/fluent/fluent.conf
}

INSANE_SKIP:${PN} = "installed-vs-shipped"
