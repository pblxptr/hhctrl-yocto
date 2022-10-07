SUMMARY = "FMT library recipe"
SECTION = ""
LICENSE = "MIT"

SRCREV = "a33701196adfad74917046096bf5a2aa0ab0bb50"
SRC_URI = "git://github.com/fmtlib/fmt.git;protocol=https;tag=9.1.0"

S = "${WORKDIR}"

inherit pkgconfig cmake

EXTRA_OECMAKE = ""

do_install () {
	install -m 0755 -d ${D}${libdir}
  install -d ${D}${includedir}
	install -m 0755 ${S}/*.h ${D}${includedir}