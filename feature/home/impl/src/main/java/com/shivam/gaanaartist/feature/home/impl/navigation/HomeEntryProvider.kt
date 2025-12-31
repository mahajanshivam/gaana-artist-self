package com.shivam.gaanaartist.feature.home.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.feature.home.api.navigation.HomeNavKey
import com.shivam.gaanaartist.feature.home.impl.HomeScreen

fun EntryProviderScope<NavKey>.homeEntry(navigator: Navigator) {

    entry<HomeNavKey> {
        HomeScreen(
            onClick = {}
        )
    }

}