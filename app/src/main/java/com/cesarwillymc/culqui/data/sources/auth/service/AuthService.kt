package com.cesarwillymc.culqui.data.sources.auth.service

import com.cesarwillymc.culqui.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.culqui.data.sources.auth.entities.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthService {
    @POST(LOGIN)
    suspend fun signIn(
        @Body body: AuthRequest
    ): AuthResponse

    @POST(REGISTER)
    suspend fun signUp(
        @Body body: AuthRequest
    ): AuthResponse

    private companion object {
        const val LOGIN = "login"
        const val REGISTER = "register"
    }
}
