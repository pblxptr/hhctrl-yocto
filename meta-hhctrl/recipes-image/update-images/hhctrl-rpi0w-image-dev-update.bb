DESCRIPTION = "Update image for hhctrl-rpi0w-image-dev"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

COMPATIBLE_MACHINE = "hhctrl"

inherit swupdate

SRC_URI = "\
    file://sw-description \
    file://emmcsetup.lua \
"

IMAGE_DEPENDS = "hhctrl-rpi0w-image-dev"

SWUPDATE_IMAGES = "hhctrl-rpi0w-image-dev"

SWUPDATE_IMAGES_FSTYPES[hhctrl-rpi0w-image-dev] = ".ext4.gz"

IMAGE_INSTALL:append = "\
	libubootenv-bin \
	swupdate \
	swupdate-progress \
    swupdate-www \
	u-boot-env \
    util-linux-sfdisk \
"
