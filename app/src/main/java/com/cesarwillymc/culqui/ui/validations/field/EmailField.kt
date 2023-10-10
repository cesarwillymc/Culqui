package com.cesarwillymc.culqui.ui.validations.field

import com.cesarwillymc.culqui.ui.validations.common.CommonRules
import com.cesarwillymc.culqui.ui.validations.TextFieldState

/**
 * Created by cesarwillymamanicanaza on 28/07/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class EmailField : TextFieldState(
    validations = listOf(CommonRules.notEmptyField, CommonRules.validEmail)
)
