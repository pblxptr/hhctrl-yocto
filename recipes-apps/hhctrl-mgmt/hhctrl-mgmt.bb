SUMMARY = "Henhouse Management Application"
LICENSE = "MIT"

inherit systemd pkgconfig cmake

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "hhctrl-mgmt.service"

SRC_URI = "git://github.com/pblxptr/hhctrl-mgmt.git;protocol=https;tag=master"
SRC_URI_append = " file://hhctrl-mgmt.service "
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f6c3b7faa0513f8653c977c58af38f5"

FILES_${PN} += "${bindir} \
  ${bindir}/hhctrl-mgmt \
  ${systemd_system_unitdir}/hhctrl-mgmt.service"

S = "${WORKDIR}/git"
EXTRA_OECMAKE = ""

DEPENDS += "boost curl spdlog fmt"

do_install_append() {
  install -m 0755 -d ${D}${bindir}
  install -d ${D}/${systemd_system_unitdir}
  install -m 0644 ${WORKDIR}/hhctrl-mgmt.service ${D}/${systemd_system_unitdir}
}