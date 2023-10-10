package com.cesarwillymc.culqui.data.sources.auth.remote

import com.cesarwillymc.culqui.data.settings.network.util.BaseRemoteDataSource
import com.cesarwillymc.culqui.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.culqui.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.culqui.data.sources.auth.service.AuthService
import com.cesarwillymc.culqui.util.state.Result
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRemoteDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthRemoteDataSource,
    BaseRemoteDataSource() {
    override suspend fun signIn(authRequest: AuthRequest): Result<AuthResponse> = getResult {
        authService.signIn(authRequest)
    }

    override suspend fun signUp(authRequest: AuthRequest): Result<AuthResponse> = getResult {
        authService.signUp(authRequest)
    }
}
