package com.shivam.gaanaartist.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.shivam.gaanaartist.core.data.repository.MainDataRepository
import com.shivam.gaanaartist.core.data.repository.NetworkMonitor
import com.shivam.gaanaartist.core.data.repository.UserDataRepository
import com.shivam.gaanaartist.core.navigation.NavigationState
import com.shivam.gaanaartist.core.navigation.rememberNavigationState
import com.shivam.gaanaartist.feature.home.api.navigation.HomeNavKey
import com.shivam.gaanaartist.navigation.TOP_LEVEL_NAV_ITEMS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@Composable
fun rememberGaanaArtistAppState(
    networkMonitor: NetworkMonitor,
    mainDataRepository: MainDataRepository,
    userDataRepository: UserDataRepository,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): GaanaArtistAppState {

    val appUiState by userDataRepository.userData
        .map { userData ->
            if (!userData.isLoggedIn) {
                AppUiState.NEEDS_LOGIN
            } else if (!userData.isOnboardingCompleted) {
                AppUiState.NEEDS_ONBOARDING
            } else {
                AppUiState.SHOW_MAIN_SCREEN
            }
        }
        .collectAsStateWithLifecycle(initialValue = AppUiState.LOADING)


//    val startKey: NavKey? = when (appUiState) {
//        AppUiState.NEEDS_LOGIN -> LoginNavKey
//        AppUiState.NEEDS_ONBOARDING -> OnboardingNavKey
//        AppUiState.SHOW_MAIN_SCREEN -> HomeNavKey
//        AppUiState.LOADING -> null // It's loading, so we don't have a start key yet.
//    }

//    val navigationState =
//        rememberNavigationState(startKey = HomeNavKey, topLevelKeys = TOP_LEVEL_NAV_ITEMS.keys)

    val navigationState = rememberNavigationState(startKey = HomeNavKey, topLevelKeys = TOP_LEVEL_NAV_ITEMS.keys)

//    NavigationTrackingSideEffect(navigationState)

//    val scope = rememberCoroutineScope()
//    LaunchedEffect(Unit) {
//        scope.launch {
//            delay(4000)
//            userDataRepository.setLoginCompleted()
//            delay(5000)
//            userDataRepository.setOnboardingCompleted()
//        }
//    }

    return remember(
        navigationState,
        coroutineScope,
        networkMonitor,
        appUiState,
    ) {
        GaanaArtistAppState(
            navigationState = navigationState,
            coroutineScope = coroutineScope,
            networkMonitor = networkMonitor,
            mainDataRepository = mainDataRepository,
            userDataRepository = userDataRepository,
            appUiState = appUiState
        )
    }
}

@Stable
class GaanaArtistAppState(
    val navigationState: NavigationState?,
    val appUiState: AppUiState,
    val coroutineScope: CoroutineScope,
    val networkMonitor: NetworkMonitor,
    val mainDataRepository: MainDataRepository,
    val userDataRepository: UserDataRepository
) {

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    // Helper property to determine if the bottom nav/navigation suite should be visible
    val shouldShowBottomBar: Boolean
        get() = appUiState == AppUiState.SHOW_MAIN_SCREEN && navigationState?.currentTopLevelKey!=null

}

enum class AppUiState{
    LOADING,
    NEEDS_LOGIN,
    NEEDS_ONBOARDING,
    SHOW_MAIN_SCREEN,
}


/**
 * Stores information about navigation events to be used with JankStats
 */
//@Composable
//private fun NavigationTrackingSideEffect(navigationState: NavigationState) {
//    TrackDisposableJank(navigationState.currentKey) { metricsHolder ->
//        metricsHolder.state?.putState("Navigation", navigationState.currentKey.toString())
//        onDispose {}
//    }
//}
