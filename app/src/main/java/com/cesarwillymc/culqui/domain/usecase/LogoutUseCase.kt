package com.cesarwillymc.culqui.domain.usecase

import com.cesarwillymc.culqui.data.sources.auth.AuthDataSource
import com.cesarwillymc.culqui.di.IoDispatcher
import com.cesarwillymc.culqui.domain.base.SuspendUseCase
import com.cesarwillymc.culqui.domain.usecase.entities.Auth
import com.cesarwillymc.culqui.domain.usecase.entities.AuthParams
import com.cesarwillymc.culqui.util.state.Result
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class LogoutUseCase @Inject constructor(
    private val repository: AuthDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, Unit>(
    dispatcher
) {
    override suspend fun execute(parameters: Unit): Result<Unit> {
        return repository.logout()
    }
}
