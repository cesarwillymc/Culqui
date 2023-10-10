package com.cesarwillymc.culqui.data.settings.network.util

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultClient

// This could be used in screen that need auth
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LoggedClient
