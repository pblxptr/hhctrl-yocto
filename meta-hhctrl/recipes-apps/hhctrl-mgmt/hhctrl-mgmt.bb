SUMMARY = "Henhouse Management Application"
LICENSE = "MIT"

inherit systemd pkgconfig cmake

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "hhctrl-mgmt.service"

SRCBRANCH = "master"
# b1e6144f6be7ac2ae02affd82170df1f760a9e7f -> v1.0.1
SRCREV = "b1e6144f6be7ac2ae02affd82170df1f760a9e7f" 
SRC_URI = "git://github.com/pblxptr/hhctrl-mgmt.git;protocol=https;branch=${SRCBRANCH};rev=${SRCREV};"

#SRCREV = "${AUTOREV}"
# SRCREV = "v1.0.1"
# SRCREV = "eed6e216180a8fd2b60d5ee9ca49a350ff6666d2"

# SRC_URI = "git://github.com/pblxptr/hhctrl-mgmt.git;protocol=https;branch=master"
SRC_URI:append = " file://hhctrl-mgmt.service "
SRC_URI:append = " file://hhctrl-dtree.json "
SRC_URI:append = " file://app-config.json "

LIC_FILES_CHKSUM = "file://LICENSE;md5=6f6c3b7faa0513f8653c977c58af38f5"

FILES:${PN} += "${bindir}/* \
  ${systemd_system_unitdir}/hhctrl-mgmt.service \
  /home/root/hhctrl-dtree.json \
  /home/root/app-config.json " 

S = "${WORKDIR}/git"

do_configure[network] =  "1"
do_compile[network] = "1"

DEPENDS += " curl boost protobuf protobuf-native grpc icon mqttcpp"

OECMAKE_GENERATOR = "Unix Makefiles"
EXTRA_OECMAKE:append = "-DFETCHCONTENT_FULLY_DISCONNECTED=OFF"

do_install:append() {
  install -m 0755 -d ${D}${bindir}
  install -d ${D}/${systemd_system_unitdir}
  install -m 0644 ${WORKDIR}/hhctrl-mgmt.service ${D}/${systemd_system_unitdir}
  install -d ${D}/home/root
  install -m 0644 ${WORKDIR}/hhctrl-dtree.json ${D}/home/root
  install -m 0644 ${WORKDIR}/app-config.json ${D}/home/root
}
