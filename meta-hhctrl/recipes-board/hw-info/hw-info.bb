SUMMARY = "Hardware info"
SECTION = ""
LICENSE = "MIT"

S = "${WORKDIR}"

do_configure() {
    echo "${MACHINE}" >> ${WORKDIR}/hw-name 
}

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/hw-name ${D}${sysconfdir}/
    ln -rsf /sys/firmware/devicetree/base/serial-number ${D}${sysconfdir}/hw-serial
}

FILES:${PN} = "${sysconfdir}/hw-name ${sysconfdir}/hw-serial"
