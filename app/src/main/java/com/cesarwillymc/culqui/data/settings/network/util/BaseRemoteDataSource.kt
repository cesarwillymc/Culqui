package com.cesarwillymc.culqui.data.settings.network.util

import com.cesarwillymc.culqui.data.settings.network.util.error.ErrorApi
import com.cesarwillymc.culqui.data.settings.network.util.error.ErrorHandler
import com.cesarwillymc.culqui.data.settings.network.util.error.ErrorSource
import com.cesarwillymc.culqui.util.state.Result
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
abstract class BaseRemoteDataSource : ErrorHandler {

    protected suspend fun <Out> getResult(
        call: suspend () -> Out
    ): Result<Out> = try {
        Result.Success(call())
    } catch (e: Exception) {
        Result.Error(exception = getError(e))
    }

    override fun getError(throwable: Throwable): ErrorSource = when (throwable) {
        is IOException -> ErrorSource.Network
        is HttpException -> getErrorFromBody(throwable.response()?.errorBody(), throwable.code())
        else -> ErrorSource.Unknown
    }

    private fun getErrorFromBody(errorBody: ResponseBody?, code: Int): ErrorSource {
        return errorBody?.let {
            try {
                val errorApi = Gson().fromJson(it.string(), ErrorApi::class.java)
                ErrorSource.ServiceError(
                    errorCode = code.toString(),
                    errorMessage = errorApi.error
                )
            } catch (jsonException: JsonSyntaxException) {
                ErrorSource.Unknown
            }
        } ?: ErrorSource.Unknown
    }
}
