package com.cesarwillymc.culqui.presentation.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.cesarwillymc.culqui.ui.validations.field.EmailField
import com.cesarwillymc.culqui.ui.validations.field.NameField
import com.cesarwillymc.culqui.ui.validations.field.PasswordField
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    val passwordText  = PasswordField()
    val nameText  = NameField()
}