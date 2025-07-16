SUMMARY = "Fluentdu Open-Source Log Collector"
HOMEPAGE = "https://www.fluentd.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ffc336af228834e68e0a4d38da165f7"

SRCREV = "b4814cb672f8d0fef2bf441214aae368a4091662"

SRC_URI = "git://github.com/fluent/fluentd.git;protocol=https;branch=master"

RDEPENDS:${PN} = "cool.io http-parser.rb msgpack serverengine sigdump strptime tzinfo tzinfo-data yajl-ruby"

inherit ruby

do_install:append() {
	install -d ${D}/etc/fluent/
	install ${S}/fluent.conf ${D}/etc/fluent/fluent.conf
}

INSANE_SKIP:${PN} = "installed-vs-shipped"
