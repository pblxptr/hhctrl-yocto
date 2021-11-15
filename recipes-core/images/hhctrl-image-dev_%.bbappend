DESCRIPTION = "Henhouse Controller dev image"

inherit core-image

TOOLCHAIN_TARGET_TASK_append = " libstdc++-staticdev"

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