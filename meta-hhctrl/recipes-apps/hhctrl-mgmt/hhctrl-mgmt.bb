SUMMARY = "Henhouse Management Application"
LICENSE = "MIT"

inherit systemd pkgconfig cmake

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "hhctrl-mgmt.service"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/pblxptr/hhctrl-mgmt.git;protocol=https;branch=dev"
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

#do_configure:prepend() {
#  echo "set(ENV{GIT_PROXY_COMMAND} \"oe-git-proxy\")" | cat - ${WORKDIR}/git/CMakeLists.txt > temp && mv temp ${WORKDIR}/git/CMakeLists.txt
#  echo "set(ENV{NO_PROXY} *)" | cat - ${WORKDIR}/git/CMakeLists.txt > temp && mv temp ${WORKDIR}/git/CMakeLists.txt
#	echo "set(ENV{no_proxy} *)" | cat - ${WORKDIR}/git/CMakeLists.txt > temp && mv temp ${WORKDIR}/git/CMakeLists.txt
#}

do_install:append() {
  install -m 0755 -d ${D}${bindir}
  install -d ${D}/${systemd_system_unitdir}
  install -m 0644 ${WORKDIR}/hhctrl-mgmt.service ${D}/${systemd_system_unitdir}
  install -d ${D}/home/root
  install -m 0644 ${WORKDIR}/hhctrl-dtree.json ${D}/home/root
  install -m 0644 ${WORKDIR}/app-config.json ${D}/home/root
}