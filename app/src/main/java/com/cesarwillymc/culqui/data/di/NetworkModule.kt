package com.cesarwillymc.culqui.data.di

import com.cesarwillymc.culqui.BuildConfig
import com.cesarwillymc.culqui.data.settings.network.util.DefaultClient
import com.cesarwillymc.culqui.data.sources.auth.service.AuthService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun gson() = Gson()

    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    @DefaultClient
    fun providesOkhttp() = OkHttpClient.Builder()
        .build()

    @Singleton
    @Provides
    fun providesAuthService(
        @DefaultClient okHttpClient: OkHttpClient
    ) = provideService<AuthService>(okHttpClient)

    private inline fun <reified T : Any> provideService(
        okhttpClient: OkHttpClient
    ): T {
        return providesRetrofit(okhttpClient).create(T::class.java)
    }
}
