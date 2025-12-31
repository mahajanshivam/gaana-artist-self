package com.shivam.gaanaartist.feature.home.api.navigation

import androidx.navigation3.runtime.NavKey
import com.shivam.gaanaartist.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
object HomeNavKey : NavKey

fun Navigator.NavigateToDemoPage(demoArg: String) {
//    navigate(key = MusicNavKey())
}