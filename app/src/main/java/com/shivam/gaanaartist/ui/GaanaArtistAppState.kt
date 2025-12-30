package com.shivam.gaanaartist.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.shivam.gaanaartist.core.data.repository.MainDataRepository
import com.shivam.gaanaartist.core.data.repository.NetworkMonitor
import com.shivam.gaanaartist.core.navigation.NavigationState
import com.shivam.gaanaartist.core.navigation.rememberNavigationState
import com.shivam.gaanaartist.feature.home.api.navigation.HomeNavKey
import com.shivam.gaanaartist.navigation.TOP_LEVEL_NAV_ITEMS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberGaanaArtistAppState(
    networkMonitor: NetworkMonitor,
    mainDataRepository: MainDataRepository,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): GaanaArtistAppState {

    val navigationState =
        rememberNavigationState(startKey = HomeNavKey, topLevelKeys = TOP_LEVEL_NAV_ITEMS.keys)

//    NavigationTrackingSideEffect(navigationState)

    return remember(
        navigationState,
        coroutineScope,
        networkMonitor,
    ) {
        GaanaArtistAppState(
            navigationState = navigationState,
            coroutineScope = coroutineScope,
            networkMonitor = networkMonitor,
            mainDataRepository = mainDataRepository,
        )
    }
}

@Stable
class GaanaArtistAppState(
    val navigationState: NavigationState,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor,
    mainDataRepository: MainDataRepository
) {

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

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
