SUMMARY = "iCon library recipe"
SECTION = ""
LICENSE = "MIT"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/pblxptr/icon.git;protocol=https;branch=dev"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f6c3b7faa0513f8653c977c58af38f5"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DCMAKE_THREAD_LIBS_INIT=-lpthread"

DEPENDS += "boost protobuf protobuf-native grpc spdlog cppzmq"

RDEPENDS:${PN}-dev = "cppzmq-dev"