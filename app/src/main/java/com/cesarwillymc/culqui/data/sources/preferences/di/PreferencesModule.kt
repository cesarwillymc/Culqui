package com.cesarwillymc.culqui.data.sources.preferences.di

import com.cesarwillymc.culqui.data.sources.preferences.PreferencesDao
import com.cesarwillymc.culqui.data.sources.preferences.PreferencesDaoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesModule {
    @Binds
    abstract fun bindPreferencesDao(dao: PreferencesDaoImpl): PreferencesDao
}
