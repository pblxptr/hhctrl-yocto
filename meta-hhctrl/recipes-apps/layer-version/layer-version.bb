SUMMARY = "Add file to contain tag from Git" 
LICENSE = "MIT" 

do_configure[nostamp] = "1"

def git_drop_tag_prefix(version):
    import re
    if re.match("v\d", version):
        return version[1:]
    else:
        return version

LAYER_VERSION = "${@git_drop_tag_prefix(get_git_pv(d))}"

S = "${WORKDIR}/git"
FILEEXTRAPATHS:append := "${THISDIR}/${PN}:"

do_configure:append() {
	echo "${LAYER_VERSION}" > ${WORKDIR}/sw-version
}

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/sw-version ${D}${sysconfdir}/
}

def get_git_pv(d):
    import subprocess
    top_dir = d.getVar('TOPDIR')
    cmd = "git describe --tags --dirty --broken --always"
    proc = subprocess.Popen(cmd, stdout=subprocess.PIPE, shell=True, cwd=top_dir)
    out, err = proc.communicate()
    return out.decode("utf-8").rstrip()

FILES:${PN} += "${sysconfdir}/sw-version"


