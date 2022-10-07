SUMMARY = "MQTT CPP library recipe"
SECTION = ""
LICENSE = "BSL-1.0"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/redboltz/mqtt_cpp.git;protocol=https;branch=master"
LIC_FILES_CHKSUM = "file://LICENSE_1_0.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

S = "${WORKDIR}/git"

inherit cmake

ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-dev = "1"

EXTRA_OECMAKE = "-DMQTT_BUILD_TESTS=OFF \
    -DMQTT_BUILD_EXAMPLES=OFF \
    -DMQTT_USE_LOG=OFF \
    -DMQTT_STD_VARIANT=ON \
    -DMQTT_STD_OPTIONAL=ON \
    -DMQTT_STD_STRING_VIEW=ON \
    -DMQTT_STD_ANY=ON \
    -DMQTT_STD_SHARED_PTR_ARRAY=ON"

PACKAGES = "${PN}-dev"

DEPENDS = "boost"
RDEPENDS:${PN}-dev = ""