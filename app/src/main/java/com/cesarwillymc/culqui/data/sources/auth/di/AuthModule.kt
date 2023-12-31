package com.cesarwillymc.culqui.data.sources.auth.di

import com.cesarwillymc.culqui.data.sources.auth.AuthDataSource
import com.cesarwillymc.culqui.data.sources.auth.AuthRepository
import com.cesarwillymc.culqui.data.sources.auth.mapper.AuthResultMapper
import com.cesarwillymc.culqui.data.sources.auth.mapper.AuthResultMapperImpl
import com.cesarwillymc.culqui.data.sources.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.culqui.data.sources.auth.remote.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Singleton
    @Binds
    abstract fun bindsSearchDataSource(searchRepository: AuthRepository): AuthDataSource

    @Singleton
    @Binds
    abstract fun bindsSearchResultMapper(
        searchResultMapper: AuthResultMapperImpl
    ): AuthResultMapper

    @Singleton
    @Binds
    abstract fun bindsSearchRemoteDataSource(
        searchResultRemoteDataSource: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource
}
