DESCRIPTION = "Henhouse Controller dev image"

inherit core-image

TOOLCHAIN_TARGET_TASK:append = " libstdc++-staticdev"

## EXPERIMENTAL
TOOLCHAIN_TARGET_TASK:append = " icon-staticdev mqttcpp-dev kernel-devsrc"
TOOLCHAIN_HOST_TASK:append = " nativesdk-protobuf-compiler"
SDKIMAGE_FEATURES = "dev-pkgs staticdev-pkgs dbg-pkgs"
###

SUPPORT_LIBRARIES = " \
  boost \
  protobuf \
  curl \
  spdlog \
  fmt \
  zeromq \
"

APPS = " \
 hhctrl-mgmt \
"

IMAGE_INSTALL += " \
  ${APPS} \
"
