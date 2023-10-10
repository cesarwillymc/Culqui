package com.cesarwillymc.culqui.data.sources.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import com.cesarwillymc.culqui.util.constants.EMPTY_STRING
import com.cesarwillymc.culqui.util.state.Result
import javax.inject.Inject

class PreferencesDaoImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : PreferencesDao {

    private companion object {

        const val USER_SESSION = "user_information"
    }

    override val getToken: Result<String>
        get() = try {
            val session = sharedPreferences.getString(USER_SESSION, EMPTY_STRING)
            Result.Success(data = session.orEmpty())
        } catch (e: Exception) {
            Result.Error(e)
        }

    override fun saveToken(value: String): Result<Unit> {
        sharedPreferences.edit {
            this.putString(USER_SESSION, value)
        }
        return Result.Success(Unit)
    }

    override val isLogged: Result<Boolean>
        get() = try {
            val session = sharedPreferences.getString(USER_SESSION, EMPTY_STRING)
            Result.Success(data = !session.isNullOrBlank())
        } catch (e: Exception) {
            Result.Error(e)
        }

    override fun cleanPreferences(): Result<Unit> {
        sharedPreferences.edit {
            remove(USER_SESSION)
        }
        return Result.Success(Unit)
    }
}
