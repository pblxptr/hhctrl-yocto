SUMMARY = "FMT library recipe"
SECTION = ""
LICENSE = "MIT"

SRC_URI = "git://github.com/fmtlib/fmt.git;protocol=https;tag=master"

S = "${WORKDIR}"

inherit pkgconfig cmake

EXTRA_OECMAKE = ""

do_install () {
	install -m 0755 -d ${D}${libdir}
  install -d ${D}${includedir}
	install -m 0755 ${S}/*.h ${D}${includedir}