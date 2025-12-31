package com.shivam.gaanaartist.feature.audience.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.feature.audience.api.navigation.AudienceNavKey
import com.shivam.gaanaartist.feature.audience.impl.AudienceScreen

fun EntryProviderScope<NavKey>.audienceEntry(navigator: Navigator){

    entry<AudienceNavKey>{
        AudienceScreen(onClick = {})
    }
}