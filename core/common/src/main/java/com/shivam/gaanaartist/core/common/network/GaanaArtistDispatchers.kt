package com.shivam.gaanaartist.core.common.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: GaanaArtistDispatchers)

enum class GaanaArtistDispatchers {
    Default,
    IO
}