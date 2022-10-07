DESCRIPTION = "Henhouse Controller dev image"

inherit core-image

TOOLCHAIN_TARGET_TASK:append = " libstdc++-staticdev"

TOOLCHAIN_TARGET_TASK:append = " mqttcpp-dev kernel-devsrc"
TOOLCHAIN_HOST_TASK:append = " nativesdk-protobuf-compiler"
SDKIMAGE_FEATURES = "dev-pkgs staticdev-pkgs dbg-pkgs"
###

IMAGE_FSTYPES += "ext4.gz"

SUPPORT_LIBRARIES = " \
  boost \
  protobuf \
  curl \
  spdlog \
  fmt \
  zeromq \
"

SWUPDATE = "\
	libubootenv-bin \
	swupdate \
	swupdate-progress \
  swupdate-www \
	u-boot-env \
  util-linux-sfdisk \
"

APPS = " \
 hhctrl-mgmt \
"

IMAGE_INSTALL = " \
  packagegroup-base \
  ${APPS} \
  ${SWUPDATE} \
"
