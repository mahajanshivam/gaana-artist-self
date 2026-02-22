package com.shivam.gaanaartist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.shivam.gaanaartist.LocalSnackbarHostState
import com.shivam.gaanaartist.R
import com.shivam.gaanaartist.core.designsystem.component.GaanaArtistNavigationSuiteScaffold
import com.shivam.gaanaartist.core.navigation.NavigationState
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.core.navigation.toEntries
import com.shivam.gaanaartist.feature.audience.impl.navigation.audienceEntry
import com.shivam.gaanaartist.feature.canvas.impl.navigation.canvasEntry
import com.shivam.gaanaartist.feature.home.api.navigation.HomeNavKey
import com.shivam.gaanaartist.feature.home.impl.navigation.homeEntry
import com.shivam.gaanaartist.feature.login.impl.navigation.loginEntry
import com.shivam.gaanaartist.feature.music.impl.navigation.musicEntry
import com.shivam.gaanaartist.feature.onboarding.impl.navigation.onboardingEntry
import com.shivam.gaanaartist.feature.profile.impl.navigation.profileEntry
import com.shivam.gaanaartist.navigation.TOP_LEVEL_NAV_ITEMS
import kotlinx.coroutines.launch

@Composable
fun GaanaArtistApp(
    appState: GaanaArtistAppState,
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    appState.navigationState ?: return
    val isOffline by appState.isOffline.collectAsStateWithLifecycle()
    val notConnectedMessage = stringResource(R.string.not_connected)
    val snackbarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()

//    val navigator = remember { Navigator(appState.navigationState) }

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = Indefinite,
            )
        }
    }
    CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {
        when (appState.appUiState) {
            AppUiState.SHOW_MAIN_SCREEN -> {
                MainContentNavigationSuiteScaffold(
                    appState = appState,
//                    navigator = navigator,
                    windowAdaptiveInfo = windowAdaptiveInfo,
                    snackBarHostState = snackbarHostState
                )
            }

            AppUiState.NEEDS_LOGIN -> {

                // If you want to implement login flow with its own backstack,
                // you can implement a different backstack in a simple manner parallelly
                // without things like top level nav keys etc etc.
                // That stack will have its own navigation destinations belonging only to the login flow

                // The root level stack switching can de done in this very when block
                // on the basis of the value of AppUiState

                Column {
                    Text("Login PAGE")

                    Button(
                        onClick = {
                            // change the login state of the app properly with API and DB calls
                            coroutineScope.launch {
                                appState.userDataRepository.setLoginCompleted()
                            }
                        })
                    { Text("Login") }
                }

            }

            AppUiState.NEEDS_ONBOARDING -> {
                // If you want to implement onboarding flow with its own backstack,
                // you can implement a different backstack in a simple manner parallelly
                // without things like top level nav keys etc etc.
                // That stack will have its own navigation destinations belonging only to the login flow

                Text("Onboarding PAGE")

                Button(
                    onClick = {
                        // change the login state of the app properly with API and DB calls
                        coroutineScope.launch {
                            appState.userDataRepository.setOnboardingCompleted()
                        }
                    })
                { Text("Complete onboarding") }

            }

            AppUiState.LOADING -> {
                // this is the initial state, for now we do not show anything
                // and the splash screen continues to show
            }
        }
    }

}

@Composable
fun MainContentNavigationSuiteScaffold(
    appState: GaanaArtistAppState,
//    navigator: Navigator,
    windowAdaptiveInfo: WindowAdaptiveInfo,
    snackBarHostState: SnackbarHostState
) {
    appState.navigationState ?: return

    val navigator = remember { Navigator(appState.navigationState) }

    GaanaArtistNavigationSuiteScaffold(
        navigationSuiteItems = {
            TOP_LEVEL_NAV_ITEMS.forEach { (navKey, navItem) ->
                val selected = navKey == appState.navigationState?.currentTopLevelKey
                item(
                    selected = selected,
                    onClick = {
                        navigator.navigate(navKey)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(navItem.navIcon),
                            contentDescription = null,
                        )
                    },
//                        selectedIcon = {
//                            Icon(
//                                painter =  painterResource( navItem.navIcon),
//                                contentDescription = null,
//                            )
//                        },
                    label = { Text(stringResource(navItem.navTitle)) },

//                        modifier = Modifier
//                            .testTag("GaanaArtistNavItem")
//                            .then(if (hasUnread) Modifier.notificationDot() else Modifier),

                )

            }
        },
        windowAdaptiveInfo = windowAdaptiveInfo
    ) {
        MainAppContent(navigator, appState.navigationState, snackBarHostState = snackBarHostState)
    }
}

@Composable
fun MainAppContent(
    navigator: Navigator,
    navigationState: NavigationState,
    modifier: Modifier = Modifier,
    snackBarHostState: SnackbarHostState,
) {
    Scaffold(
        modifier = modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = {
            SnackbarHost(
                snackBarHostState,
                modifier = Modifier.windowInsetsPadding(
                    WindowInsets.safeDrawing.exclude(
                        WindowInsets.ime,
                    ),
                ),
            )
        },
    ) { padding ->

        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {

//                    var shouldShowTopAppBar = false
//                    // TODO:: this shows top app bar only for top level destinations, not inner screens, change later as required
//                    if (appState.navigationState.currentKey in appState.navigationState.topLevelKeys) {
//
//                        shouldShowTopAppBar = true
//
//                        val destination =
//                            TOP_LEVEL_NAV_ITEMS[appState.navigationState.currentTopLevelKey]
//                                ?: error("Top level nav item not found for ${appState.navigationState.currentTopLevelKey}")
//
//                        GaanaArtistTopAppBar(
//                            titleRes = destination.navTitle,
//                            navigationIcon = desSysR.drawable.ic_settings_nav,
//                            navigationIconContentDescription = stringResource(
//                                id = settingsR.string.feature_settings_api_top_app_bar_action_settings_icon_description,
//                            ),
//                            actionIcon = desSysR.drawable.ic_settings_nav,
//                            actionIconContentDescription = stringResource(
//                                id = settingsR.string.feature_settings_api_top_app_bar_action_settings_icon_description,
//                            ),
//                            colors = TopAppBarDefaults.topAppBarColors(
//                                containerColor = Color.Transparent,
//                            ),
////                            onActionClick = { onTopAppBarActionClick() },
////                            onNavigationClick = { navigator.navigate(SearchNavKey) },
//                        )
//                    }

            Box(
                modifier = Modifier.consumeWindowInsets(
//                            if (shouldShowTopAppBar) {
//                                WindowInsets.safeDrawing.only(WindowInsetsSides.Top)
//                            } else {
                    WindowInsets(0, 0, 0, 0)
//                            },
                ),
            ) {
                val entryProvider = entryProvider {
                    homeEntry(navigator)
                    musicEntry(navigator)
                    audienceEntry(navigator)
                    canvasEntry(navigator)
                    profileEntry(navigator)
                }

                NavDisplay(
                    entries = navigationState.toEntries(entryProvider),
//                            sceneStrategy = listDetailStrategy,
                    onBack = { navigator.goBack() },
                )
            }

        }
    }

}

