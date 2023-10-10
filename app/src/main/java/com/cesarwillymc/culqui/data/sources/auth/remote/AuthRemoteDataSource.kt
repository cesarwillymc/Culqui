package com.cesarwillymc.culqui.data.sources.auth.remote

import com.cesarwillymc.culqui.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.culqui.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.culqui.util.state.Result

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthRemoteDataSource {
    suspend fun signIn(
        authRequest: AuthRequest
    ): Result<AuthResponse>

    suspend fun signUp(
        authRequest: AuthRequest
    ): Result<AuthResponse>
}
