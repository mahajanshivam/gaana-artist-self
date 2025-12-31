package com.shivam.gaanaartist.feature.home.impl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.shivam.gaanaartist.core.model.data.HomeUiModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUiState = homeViewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(homeUiState = homeUiState.value, modifier = modifier)
}

@Composable
fun HomeScreen(homeUiState: HomeUiState, modifier: Modifier) {

    when (homeUiState) {

        is HomeUiState.Loading -> {
            // handle home page loading - show shimmer if required. ask
        }

        is HomeUiState.Success -> {
            HomeSuccessScreen(homeUiState.homeUiData)
        }
    }
}

@Composable
fun HomeSuccessScreen(
    homeUiData: HomeUiModel,
    modifier: Modifier = Modifier
) {    // TODO:: think suitable name
    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            modifier = Modifier.align(alignment = Alignment.Center),
            text = homeUiData.homeSampleTextRemoveLater
        )
    }
}