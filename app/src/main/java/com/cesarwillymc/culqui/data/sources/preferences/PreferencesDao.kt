package com.cesarwillymc.culqui.data.sources.preferences
import com.cesarwillymc.culqui.util.state.Result

interface PreferencesDao {

    val getToken: Result<String>
    fun saveToken(value: String): Result<Unit>

    val isLogged: Result<Boolean>
    fun cleanPreferences(): Result<Unit>
}
