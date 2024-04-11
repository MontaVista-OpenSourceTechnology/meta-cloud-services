SUMMARY = "Curated set of Ansible collections included in addition to ansible-core"
DESCRIPTION = "Ansible is a radically simple model-driven configuration management, \
multi-node deployment, and remote task execution system. Ansible works \
over SSH and does not require any software or daemons to be installed \
on remote nodes. Extension modules can be written in any language and \
are transferred to managed machines automatically. \
This package provides a curated set of Ansible collections included in addition \
to ansible-core."
HOMEPAGE = "https://pypi.org/project/ansible/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

PYPI_PACKAGE = "ansible"

inherit pypi setuptools3

SRC_URI[sha256sum] = "dd431c63380e18c3faca3288ebde8ce2f4f992363ab558a3c11c8f2032d90867"

RDEPENDS:${PN} = " \
    bash \
    python3-ansible \
"
