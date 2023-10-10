package com.cesarwillymc.culqui.ui.validations.field

import com.cesarwillymc.culqui.ui.validations.TextFieldState
import com.cesarwillymc.culqui.ui.validations.common.CommonRules
import com.cesarwillymc.culqui.ui.validations.entities.FieldValidator

/**
 * Created by cesarwillymamanicanaza on 28/07/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class NameField : TextFieldState(
    validations = listOf(
        CommonRules.notEmptyField,
        FieldValidator(
            isSuccessValidator = { it.length > 3 }
        )
    )
)
