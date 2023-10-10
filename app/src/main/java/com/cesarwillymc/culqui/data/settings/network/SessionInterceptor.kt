package com.cesarwillymc.culqui.data.settings.network

import com.cesarwillymc.culqui.data.sources.preferences.PreferencesDao
import com.cesarwillymc.culqui.util.extension.orEmpty
import com.cesarwillymc.culqui.util.state.dataOrNull
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

// Here the token could be used
class SessionInterceptor @Inject constructor(
    private val preferencesDao: PreferencesDao
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val interceptor = chain
            .request()
            .newBuilder().apply {
                addHeader(TOKEN_KEY, preferencesDao.getToken.dataOrNull().orEmpty())
            }
            .build()

        return chain.proceed(interceptor)
    }

    companion object {
        const val TOKEN_KEY = "token"
    }
}
