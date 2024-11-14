DESCRIPTION = "Ansible is a simple IT automation platform that makes your applications and systems easier to deploy."
HOMEPAGE = "https://github.com/ansible/ansible/"
SECTION = "devel/python"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

SRCNAME = "ansible"

SRC_URI = "git://github.com/ansible/ansible.git;protocol=https;branch=stable-2.17"

SRCREV = "05e01efa8534d19956133e19e9e84aad720abb0d"

S = "${WORKDIR}/git"

ANSIBLE_WHITELIST_MODULES ?= "commands files system network/ovs __pycache__ service"

do_install:append() {
    set +e

    # install hosts and conf
    install -d ${D}/${sysconfdir}/ansible

    # There is no default inventory configuration installed for ansible,
    # so we use the example as a template to improve OOBE.
    install ${S}/examples/hosts ${D}/${sysconfdir}/ansible/
    install ${S}/examples/ansible.cfg ${D}/${sysconfdir}/ansible/

    # do not gather machine's information, which could reduce setup time
    sed -i "s|^#gathering = implicit|gathering = explicit|g" \
        ${D}/${sysconfdir}/ansible/ansible.cfg

    for d in $(ls ${D}/${libdir}/python${PYTHON_BASEVERSION}/site-packages/ansible/modules); do
	if [ -d ${D}/${libdir}/python${PYTHON_BASEVERSION}/site-packages/ansible/modules/$d ]; then
	    match=
	    rm_target=
	    for w in ${ANSIBLE_WHITELIST_MODULES}; do
		m=$(echo $w | grep $d)
		if [ $? -eq 0 ]; then
		    match=t
		    match_word=$m
		fi
	    done
	    if [ -n "$match" ]; then
		echo $match_word | grep -q "/"
		if [ $? -eq 0 ]; then
		    for d2 in $(ls ${D}/${libdir}/python${PYTHON_BASEVERSION}/site-packages/ansible/modules/$d); do
			if [ -d ${D}/${libdir}/python${PYTHON_BASEVERSION}/site-packages/ansible/modules/$d/$d2 ]; then
			    sub_remove=t
			    for w in ${ANSIBLE_WHITELIST_MODULES}; do
				m=$(echo $w | grep $d2)
				if [ $? -eq 0 ]; then
				    sub_remove=
				fi
			    done
			    if [ -n "$sub_remove" ]; then
				echo "[info]: removing $d/$d2"
				rm -rf ${D}/${libdir}/python${PYTHON_BASEVERSION}/site-packages/ansible/modules/$d/$d2
			    else
				echo "[info]: whitlisting $d/$d2"
			    fi
			fi
		    done
		else
		    echo "[info]: whitlisting $d"
		fi
	    else
		echo "[info]: removing $d"
		rm -rf ${D}/${libdir}/python${PYTHON_BASEVERSION}/site-packages/ansible/modules/$d
	    fi
	fi
    done
}

CLEANBROKEN = "1"
