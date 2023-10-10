package com.cesarwillymc.culqui.data.sources.auth.mapper

import com.cesarwillymc.culqui.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.culqui.domain.usecase.entities.Auth
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/9/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthResultMapperImpl @Inject constructor() : AuthResultMapper {
    override fun fromResponseToDomain(info: AuthResponse): Auth {
        return Auth(info.token)
    }

}