package com.cesarwillymc.culqui.data.sources.auth

import com.cesarwillymc.culqui.domain.usecase.entities.Auth
import com.cesarwillymc.culqui.util.state.Result

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthDataSource {
    suspend fun signIn(
        email: String,
        password: String
    ): Result<Auth>

    suspend fun signUp(
        email: String,
        password: String
    ): Result<Auth>

    suspend fun saveToken(
        token: String
    ): Result<Unit>

    suspend fun logout(): Result<Unit>

    suspend fun isLogged(): Result<Boolean>
}
