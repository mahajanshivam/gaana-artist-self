package com.shivam.gaanaartist.feature.profile.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.feature.profile.api.navigation.ProfileNavKey
import com.shivam.gaanaartist.feature.profile.impl.ProfileScreen

fun EntryProviderScope<NavKey>.profileEntry(navigator: Navigator){

    entry<ProfileNavKey>{
        ProfileScreen(onClick = {})
    }
}