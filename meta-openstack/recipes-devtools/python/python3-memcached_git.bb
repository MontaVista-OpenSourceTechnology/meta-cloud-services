SUMMARY = "Pure python memcached client"
DESCRIPTION = "\
  This software is a 100% Python interface to the memcached memory cache daemon. \
  It is the client side software which allows storing values in one or more, possibly remote, \
  memcached servers. Search google for memcached for more information."
HOMEPAGE = "https://pypi.python.org/pypi/python-memcached/"
SECTION = "devel/python"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://PSF.LICENSE;md5=7dd786e8594f1e787da94a946557b40e"

PV = "1.59+git${SRCPV}"
SRCREV = "959e068fec8b4c956b0d82269336818e667726e7"

SRC_URI = "git://github.com/linsomniac/python-memcached.git;branch=master;protocol=https"

inherit setuptools3

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-pickle \
    "

