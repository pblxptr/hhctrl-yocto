DESCRIPTION = "Henhouse Controller dev image"

inherit core-image

SUPPORT_LIBRARIES = " \
  poco \
  boost \
  curl \
  spdlog \
  fmt \
"

APPS = " \
  hhctrl-mgmt \
"

IMAGE_INSTALL += " \
  ${SUPPORT_LIBRARIES} \
  ${APPS} \
"