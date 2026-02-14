package com.shivam.gaanaartist.feature.onboarding.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.feature.home.api.navigation.HomeNavKey
import com.shivam.gaanaartist.feature.onboarding.api.navigation.OnboardingNavKey
import com.shivam.gaanaartist.feature.onboarding.impl.OnboardingScreen

fun EntryProviderScope<NavKey>.onboardingEntry(navigator: Navigator){

    entry<OnboardingNavKey> {
        OnboardingScreen(
            onBoardingCompleted = {
                navigator.navigate(key = HomeNavKey)
            }
        )
    }

}