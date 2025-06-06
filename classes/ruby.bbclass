#
# Copyright (C) 2014 Wind River Systems, Inc.
# Copyright (c) 2024 Bruce Ashfield, Inc.
#
DEPENDS += " \
    ruby-native \
"
RDEPENDS:${PN} += " \
    ruby \
"

SRCNAME ?= "${PN}"

#${PN}_do_compile[depends] += "ruby-native:do_populate_sysroot"

def get_rubyversion(p):
    import re
    from os.path import isfile
    import subprocess
    found_version = "SOMETHING FAILED!"

    cmd = "%s/ruby" % p

    if not isfile(cmd):
       return found_version

    version = subprocess.Popen([cmd, "--version"], stdout=subprocess.PIPE).communicate()[0]

    r = re.compile("ruby ([0-9]+\.[0-9]+\.[0-9]+)*")
    m = r.match(version)
    if m:
        found_version = m.group(1)

    return found_version

def get_rubygemslocation(p):
    import re
    from os.path import isfile
    import subprocess
    found_loc = "SOMETHING FAILED!"

    cmd = "%s/gem" % p

    if not isfile(cmd):
       return found_loc

    loc = subprocess.Popen([cmd, "env"], stdout=subprocess.PIPE).communicate()[0]

    r = re.compile(".*\- (/usr.*/ruby/gems/.*)")
    for line in loc.split('\n'):
        m = r.match(line)
        if m:
            found_loc = m.group(1)
            break

    return found_loc

def get_rubygemsversion(p):
    import re
    from os.path import isfile
    import subprocess
    found_version = "SOMETHING FAILED!"

    cmd = "%s/gem" % p

    if not isfile(cmd):
       return found_version

    version = subprocess.Popen([cmd, "env", "gemdir"], stdout=subprocess.PIPE).communicate()[0]

    r = re.compile(".*([0-9]+\.[0-9]+\.[0-9]+)$")
    m = r.match(version.decode("utf-8"))
    if m:
        found_version = m.group(1)

    return found_version

RUBY_VERSION ?= "${@get_rubyversion("${STAGING_BINDIR_NATIVE}")}"
RUBY_GEM_DIRECTORY ?= "${@get_rubygemslocation("${STAGING_BINDIR_NATIVE}")}"
RUBY_GEM_VERSION ?= "${@get_rubygemsversion("${STAGING_BINDIR_NATIVE}")}"

export GEM_HOME = "${STAGING_DIR_NATIVE}/usr/lib/ruby/gems/${RUBY_GEM_VERSION}"

RUBY_BUILD_GEMS ?= "${SRCNAME}.gemspec"
RUBY_INSTALL_GEMS ?= "${SRCNAME}-${PV}.gem"

RUBY_COMPILE_FLAGS ?= 'LANG="en_US.UTF-8" LC_ALL="en_US.UTF-8"'

ruby_gen_extconf_fix() {
	cat<<EOF>append
  RbConfig::MAKEFILE_CONFIG['CPPFLAGS'] = ENV['CPPFLAGS'] if ENV['CPPFLAGS']
  \$CPPFLAGS = ENV['CPPFLAGS'] if ENV['CPPFLAGS']
  RbConfig::MAKEFILE_CONFIG['CC'] = ENV['CC'] if ENV['CC']
  RbConfig::MAKEFILE_CONFIG['LD'] = ENV['LD'] if ENV['LD']
  RbConfig::MAKEFILE_CONFIG['CFLAGS'] = ENV['CFLAGS'] if ENV['CFLAGS']
  RbConfig::MAKEFILE_CONFIG['CXXFLAGS'] = ENV['CXXFLAGS'] if ENV['CXXFLAGS']
EOF
	cat append2>>append
	sysroot_ruby=${STAGING_INCDIR}/ruby-${RUBY_GEM_VERSION}
	ruby_arch=`ls -1 ${sysroot_ruby} |grep -v ruby |tail -1 2> /dev/null`
	cat<<EOF>>append
  system("perl -p -i -e 's#^topdir.*#topdir = ${sysroot_ruby}#' Makefile")
  system("perl -p -i -e 's#^hdrdir.*#hdrdir = ${sysroot_ruby}#' Makefile")
  system("perl -p -i -e 's#^arch_hdrdir.*#arch_hdrdir = ${sysroot_ruby}/\\\\\$(arch)#' Makefile")
  system("perl -p -i -e 's#^arch =.*#arch = ${ruby_arch}#' Makefile")
  system("perl -p -i -e 's#^LIBPATH =.*#LIBPATH = -L.#' Makefile")
  system("perl -p -i -e 's#^dldflags =.*#dldflags = ${LDFLAGS}#' Makefile")
EOF
}

do_generate_spec () {
    if [ -z "${GEM_SPEC_FILE}" ]; then
	return 0
    fi

    if [ -e "${UNPACKDIR}/${GEM_SPEC_FILE}" ]; then
	cp -f "${UNPACKDIR}/${GEM_SPEC_FILE}" "${S}/${GEM_SPEC_FILE}"
	return 0
    fi
}

do_generate_spec[vardepsexclude] += "prefix_native"
addtask do_generate_spec before do_patch

ruby_do_compile() {
	if [ -f ${UNPACKDIR}/extconf.rb ]; then
		cp extconf.rb extconf.orig
		cp ${UNPACKDIR}/extconf.rb extconf.rb
	fi

	if [ -f extconf.rb -a ! -f extconf.rb.orig ] ; then
		grep create_makefile extconf.rb > append2 || (exit 0)
		ruby_gen_extconf_fix
		cp extconf.rb extconf.rb.orig
		# Patch extconf.rb for cross compile
		cat append >> extconf.rb
	fi
	for gem in ${RUBY_BUILD_GEMS}; do
		${RUBY_COMPILE_FLAGS} gem build $gem
	done
	if [ -f extconf.rb.orig ] ; then
		mv extconf.rb.orig extconf.rb
	fi
}


ruby_do_install() {
	for gem in ${RUBY_INSTALL_GEMS}; do
		gem install --ignore-dependencies --local --env-shebang --install-dir ${D}/${libdir}/ruby/gems/${RUBY_GEM_VERSION}/ $gem
	done

	# create symlink from the gems bin directory to /usr/bin
	for i in ${D}/${libdir}/ruby/gems/${RUBY_GEM_VERSION}/bin/*; do
		if [ -e "$i" ]; then
			if [ ! -d ${D}/${bindir} ]; then mkdir -p ${D}/${bindir}; fi
			b=`basename $i`
			ln -sf ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/bin/$b ${D}/${bindir}/$b
		fi
	done
}

EXPORT_FUNCTIONS do_compile do_install

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-dev"

FILES:${PN}-dbg += " \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/gems/*/*/.debug \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/gems/*/*/*/.debug \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/gems/*/*/*/*/.debug \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/gems/*/*/*/*/*/.debug \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/extensions/*/*/*/*/*/.debug \
        "

FILES:${PN} += " \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/gems \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/cache \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/bin \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/specifications \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/build_info \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/extensions \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/plugins \
        "

FILES:${PN}-doc += " \
        ${libdir}/ruby/gems/${RUBY_GEM_VERSION}/doc \
        "

# copied from rubyv2.bbclass

# the ruby dynamic linker just uses plain .so files
# so we have to supply symlinks as part of the base package
INSANE_SKIP:${PN} += "dev-so"
# sadly the shared objects also contain some hard coded
# host paths, which are not easy to be removed
INSANE_SKIP:${PN} += "buildpaths"
# we don't care what is actually needed for the dev-package
INSANE_SKIP:${PN}-dev += "file-rdeps"
# same issue for the dev package with buildpaths
INSANE_SKIP:${PN}-dev += "buildpaths"
# some of the doc utils contain host specific full paths
# as they are mostly in binary format we are just going to
# ignore it here
INSANE_SKIP:${PN}-doc += "buildpaths"
