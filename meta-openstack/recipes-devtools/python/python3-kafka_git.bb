SUMMARY = "Python client for Apache Kafka"
HOMEPAGE = "https://github.com/mumrah/kafka-python"
SECTION = "devel/python"
LICENSE = "Apache-2.0"

PV = "2.0.2+git${SRCPV}"
SRCREV = "5bb126bf20bbb5baeb4e9afc48008dbe411631bc"

SRCNAME = "kafka-python"

LIC_FILES_CHKSUM = "file://LICENSE;md5=22efebb1e053dcc946f4b9d17f3cbbea"
SRC_URI = "git://github.com/mumrah/${SRCNAME}.git;branch=master;protocol=https"

inherit setuptools3

DEPENDS += " \
	${PYTHON_PN}-pbr \
	"

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-logging \
        ${PYTHON_PN}-compression \
	"

