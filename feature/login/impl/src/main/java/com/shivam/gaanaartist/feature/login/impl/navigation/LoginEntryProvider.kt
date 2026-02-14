package com.shivam.gaanaartist.feature.login.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.feature.login.api.LoginNavKey
import com.shivam.gaanaartist.feature.login.impl.LoginScreen
import com.shivam.gaanaartist.feature.onboarding.api.navigation.OnboardingNavKey

fun EntryProviderScope<NavKey>.loginEntry(navigator: Navigator) {
    entry<LoginNavKey> {
        LoginScreen(
            loginDone = {
                navigator.navigate(key = OnboardingNavKey)
            }
        )
    }
}