SUMMARY = "Supports the Python WSGI interface"
DESCRIPTION = "\
  The aim of mod_wsgi is to implement a simple to use Apache module which can host \
  any Python application which supports the Python WSGI interface. The module would \
  be suitable for use in hosting high performance production web sites, as well as \
  your average self managed personal sites running on web hosting services."

HOMEPAGE = "https://github.com/GrahamDumpleton/mod_wsgi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCREV = "0497f0c29e8dd06608378e6fc814a6037e8c6906"
PV = "4.9.1+git${SRCPV}"

S = "${WORKDIR}/git"

SRCNAME = "mod_wsgi"
SRC_URI = "\
	git://github.com/GrahamDumpleton/mod_wsgi.git;branch=master;protocol=https \
	file://configure.ac-allow-PYTHON-values-to-be-passed-via-en.patch \        
	"

inherit autotools-brokensep setuptools3-base

DEPENDS += "apache2-native apache2 python3"
RDEPENDS:${PN} = "python3"

EXTRA_OECONF = "\
	--with-apxs=${STAGING_BINDIR_CROSS}/apxs \
	--disable-framework \
	PYTHON_VERSION=${PYTHON_BASEVERSION} \
	PYTHON_INCLUDEPY=-I${STAGING_INCDIR}/python${PYTHON_BASEVERSION} \
	PYTHON_CFLAGS='-DNDEBUG' \
	PYTHON_LIBDIR=${STAGING_LIBDIR} \
	PYTHON_CFGDIR=${STAGING_LIBDIR}/python${PYTHON_BASEVERSION}/config \
	PYTHON_FRAMEWORKDIR='no-framework' \
	PYTHON_FRAMEWORKPREFIX=' ' \
	PYTHON_FRAMEWORK=' ' \
	PYTHON_LIBS='-lpthread -ldl  -lpthread -lutil' \
	PYTHON_SYSLIBS='-lm' \
	"

CFLAGS += " -I${STAGING_INCDIR}/apache2"

FILES:${PN} += "/etc/apache2/"
FILES:${PN}-dbg += "${libdir}/apache2/modules/.debug"

do_install:append() {
	mkdir -p ${D}/etc/apache2/modules.d/
	echo "LoadModule wsgi_module ${libexecdir}/apache2/modules/mod_wsgi.so" > \
	  ${D}/etc/apache2/modules.d/wsgi.load
}

# to load:
# LoadModule wsgi_module modules/mod_wsgi.so

# Apache/2.2.2 (Unix) mod_wsgi/1.0 Python/2.3 configured
