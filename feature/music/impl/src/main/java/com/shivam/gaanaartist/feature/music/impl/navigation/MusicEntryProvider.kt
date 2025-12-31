package com.shivam.gaanaartist.feature.music.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.feature.music.api.navigation.MusicNavKey
import com.shivam.gaanaartist.feature.music.impl.MusicScreen

fun EntryProviderScope<NavKey>.musicEntry(navigator: Navigator) {

    entry<MusicNavKey> {
        MusicScreen(onClick = {})
    }

}