SUMMARY = "Fluentdu Open-Source Log Collector"
HOMEPAGE = "https://www.fluentd.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ffc336af228834e68e0a4d38da165f7"

SRCREV = "9d113029d4550ce576d8825bfa9612aa3e55bff0"

SRC_URI = "git://github.com/fluent/fluentd.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "cool.io http-parser.rb msgpack serverengine sigdump strptime tzinfo tzinfo-data yajl-ruby"

inherit ruby

do_install:append() {
	install -d ${D}/etc/fluent/
	install ${S}/fluent.conf ${D}/etc/fluent/fluent.conf
}

INSANE_SKIP:${PN} = "installed-vs-shipped"
