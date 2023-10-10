package com.cesarwillymc.culqui.data.sources.auth

import com.cesarwillymc.culqui.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.culqui.data.sources.auth.mapper.AuthResultMapper
import com.cesarwillymc.culqui.data.sources.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.culqui.data.sources.preferences.PreferencesDao
import com.cesarwillymc.culqui.domain.usecase.entities.Auth
import com.cesarwillymc.culqui.util.state.Result
import com.cesarwillymc.culqui.util.state.dataOrNull
import com.cesarwillymc.culqui.util.state.isSuccess
import com.cesarwillymc.culqui.util.state.map
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRepository @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource,
    private val resultMapper: AuthResultMapper,
    private val sharedDao: PreferencesDao
) : AuthDataSource {
    override suspend fun signIn(email: String, password: String): Result<Auth> {
        return remoteDataSource.signIn(AuthRequest(email, password))
            .map(resultMapper::fromResponseToDomain).also {
            if (it.isSuccess) {
                sharedDao.saveToken(it.dataOrNull()?.token.orEmpty())
            }
        }
    }

    override suspend fun signUp(email: String, password: String): Result<Auth> {
        return remoteDataSource.signUp(AuthRequest(email, password))
            .map(resultMapper::fromResponseToDomain).also {
            if (it.isSuccess) {
                sharedDao.saveToken(it.dataOrNull()?.token.orEmpty())
            }
        }
    }

    override suspend fun saveToken(token: String): Result<Unit> {
        return sharedDao.saveToken(token)
    }

    override suspend fun logout(): Result<Unit> {
        return sharedDao.cleanPreferences()
    }

    override suspend fun isLogged(): Result<Boolean> {
        return sharedDao.isLogged
    }
}
