SUMMARY = "Henhouse Management Application"
SECTION = ""
LICENSE = "MIT"

SRC_URI = "git://github.com/pblxptr/hhctrl-mgmt.git;protocol=https;tag=master"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f6c3b7faa0513f8653c977c58af38f5"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

DEPENDS += "boost curl spdlog fmt"

EXTRA_OECMAKE = ""

do_install () {
	install -m 0755 -d ${D}${bindir}