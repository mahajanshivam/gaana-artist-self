package com.shivam.gaanaartist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shivam.gaanaartist.core.data.repository.MainDataRepository
import com.shivam.gaanaartist.core.data.repository.NetworkMonitor
import com.shivam.gaanaartist.core.data.repository.UserDataRepository
import com.shivam.gaanaartist.core.designsystem.theme.GaanaArtistSelfTheme
import com.shivam.gaanaartist.ui.AppUiState
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

    @Inject
    lateinit var userDataRepository: UserDataRepository

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
                mainDataRepository = mainDataRepository,
                userDataRepository = userDataRepository,
            )

            if (appState.appUiState == AppUiState.LOADING){

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    splashScreen.setKeepOnScreenCondition { true }
                    CircularProgressIndicator()
                }
            }else {

                splashScreen.setKeepOnScreenCondition { false }

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
}