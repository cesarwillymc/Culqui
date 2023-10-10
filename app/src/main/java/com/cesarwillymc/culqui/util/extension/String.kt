package com.cesarwillymc.culqui.util.extension

import com.cesarwillymc.culqui.util.constants.DEFAULT_FORMAT
import com.cesarwillymc.culqui.util.constants.FORMAT_IMAGE

fun String?.formatImageUrl() = FORMAT_IMAGE.format(
    this ?: DEFAULT_FORMAT
)
