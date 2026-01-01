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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import com.shivam.gaanaartist.core.designsystem.component.GaanaArtistTopAppBar
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.core.navigation.toEntries
import com.shivam.gaanaartist.feature.audience.impl.navigation.audienceEntry
import com.shivam.gaanaartist.feature.canvas.impl.navigation.canvasEntry
import com.shivam.gaanaartist.feature.home.impl.navigation.homeEntry
import com.shivam.gaanaartist.feature.music.impl.navigation.musicEntry
import com.shivam.gaanaartist.feature.profile.impl.navigation.profileEntry
import com.shivam.gaanaartist.navigation.TOP_LEVEL_NAV_ITEMS
import com.shivam.gaanaartist.core.designsystem.R as desSysR
import com.shivam.gaanaartist.feature.settings.api.R as settingsR

@Composable
fun GaanaArtistApp(
    appState: GaanaArtistAppState,
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    val isOffline by appState.isOffline.collectAsStateWithLifecycle()
    val notConnectedMessage = stringResource(R.string.not_connected)
    val snackbarHostState = remember { SnackbarHostState() }

    val navigator = remember { Navigator(appState.navigationState) }

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = Indefinite,
            )
        }
    }
    CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {

        GaanaArtistNavigationSuiteScaffold(
            navigationSuiteItems = {
                TOP_LEVEL_NAV_ITEMS.forEach { (navKey, navItem) ->
                    val selected = navKey == appState.navigationState.currentTopLevelKey

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

            Scaffold(
                modifier = modifier.semantics {
                    testTagsAsResourceId = true
                },
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                snackbarHost = {
                    SnackbarHost(
                        snackbarHostState,
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
                            entries = appState.navigationState.toEntries(entryProvider),
//                            sceneStrategy = listDetailStrategy,
                            onBack = { navigator.goBack() },
                        )
                    }

                }
            }

        }
    }
}

