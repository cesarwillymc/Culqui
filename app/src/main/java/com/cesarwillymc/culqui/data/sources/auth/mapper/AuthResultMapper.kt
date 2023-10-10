package com.cesarwillymc.culqui.data.sources.auth.mapper

import com.cesarwillymc.culqui.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.culqui.domain.usecase.entities.Auth

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthResultMapper {
    fun fromResponseToDomain(info: AuthResponse): Auth
}
