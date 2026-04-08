SUMMARY = "Modern concurrency tools including agents, futures, promises, thread pools, supervisors, and more. Inspired by Erlang, Clojure, Scala, Go, Java, JavaScript, and classic concurrency patterns."
HOMEPAGE = "http://www.concurrent-ruby.com"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e319104fe1435b64fc0a67032db44f02"

SRC_URI = "git://github.com/ruby-concurrency/concurrent-ruby.git;protocol=https;branch=master \
           file://0001-Removed-check-for-concurrent_ruby.jar.patch \
           "
SRCREV = "52c08fca13cc3811673ea2f6fdb244a0e42e0ebe"

do_install:append () {
    rmdir --ignore-fail-on-non-empty ${D}${libdir}/ruby/gems/${RUBY_GEM_VERSION}/plugins
}

inherit ruby
