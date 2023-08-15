SUMMARY = "Network Watcher"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SYSTEMD_SERVICE:${PN} = "network-watcher.service"
SYSTEMD_AUTO_ENABLE = "enable"

SRC_URI = "\
  file://network-watcher \
  file://network-watcher.service \
"

do_install() {
  install -d ${D}/${systemd_system_unitdir}
  install -m 0644 ${WORKDIR}/network-watcher.service ${D}/${systemd_system_unitdir}
  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/network-watcher ${D}${bindir}
}

