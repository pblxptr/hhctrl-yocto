DESCRIPTION = "Henhouse Controller dev image"

inherit core-image

TOOLCHAIN_TARGET_TASK:append = " libstdc++-staticdev"

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
