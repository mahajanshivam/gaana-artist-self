package com.shivam.gaanaartist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shivam.gaanaartist.core.data.repository.MainDataRepository
import com.shivam.gaanaartist.core.data.repository.NetworkMonitor
import com.shivam.gaanaartist.core.designsystem.theme.GaanaArtistSelfTheme
import com.shivam.gaanaartist.ui.GaanaArtistApp
import com.shivam.gaanaartist.ui.rememberGaanaArtistAppState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    @Inject
    lateinit var mainDataRepository: MainDataRepository

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    // remove if not required
                }
            }
        }

        setContent {

            val appState = rememberGaanaArtistAppState(
                networkMonitor = networkMonitor,
                mainDataRepository = mainDataRepository
            )

            CompositionLocalProvider(
//                LocalAnalyticsHelper provides analyticsHelper,
            ) {
                GaanaArtistSelfTheme {
                    GaanaArtistApp(appState)
                }
            }
        }

    }
}