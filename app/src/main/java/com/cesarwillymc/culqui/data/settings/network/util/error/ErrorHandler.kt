package com.cesarwillymc.culqui.data.settings.network.util.error

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorSource
}
