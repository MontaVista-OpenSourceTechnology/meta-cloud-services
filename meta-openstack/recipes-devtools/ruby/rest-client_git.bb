#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "A simple HTTP and REST client for Ruby"
DESCRIPTION = "A simple HTTP and REST client for Ruby, inspired by the \
Sinatra's microframework style of specifying actions: get, put, post, \
delete."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8d4c0cdd6bc54a36dbe54c0f2fa70797"

PR = "r0"

BPV = "2.0.0.rc1"
PV = "${BPV}"
SRCREV = "40eddc184a7b3fe79f9b68f291e06df4c1fbcb0b"

SRC_URI = " \
    git://github.com/rest-client/rest-client.git;branch=master;protocol=https \
    "

inherit ruby

RDEPENDS:${PN} += " \
        mime-types \
        "

BBCLASSEXTEND = "native"
