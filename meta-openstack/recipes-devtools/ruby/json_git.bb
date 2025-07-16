#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "An implementation of the JSON specification according to RFC 4627"
DESCRIPTION = "An implementation of the JSON specification according to RFC 4627"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://CHANGES;md5=af8cad0ff27a1593ac5ee461bc2d71ab"

PR = "r0"

BPV = "1.8.5"
PV = "${BPV}"
SRCREV = "4cf6c6270f52888997ec1b626b9f557db4f26f2e"

SRC_URI = " \
    git://github.com/flori/json.git;branch=v1.8;protocol=https \
    "

inherit ruby

BBCLASSEXTEND = "native"
