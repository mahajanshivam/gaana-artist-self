package com.shivam.gaanaartist.feature.home.impl

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.shivam.gaanaartist.core.designsystem.component.ThemePreviews
import com.shivam.gaanaartist.core.designsystem.theme.MainBackgroundColor
import com.shivam.gaanaartist.core.model.data.HomeScreenTopBarData
import com.shivam.gaanaartist.core.model.data.HomeUiModel
import com.shivam.gaanaartist.core.data.R as dataR

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    HomeScreenRoute(homeUiState = homeUiState, modifier = modifier, onClick = onClick)
}

@Composable
fun HomeScreenRoute(homeUiState: HomeUiState, modifier: Modifier, onClick: () -> Unit) {

    when (homeUiState) {

        is HomeUiState.Loading -> {
            // handle home page loading - show shimmer if required. ask
            Text(
                modifier = modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                text = "Loading Home page Data"
            )
        }

        is HomeUiState.Success -> {
            HomeContentScreen(homeUiState.homeUiData)
        }
    }
}

@Composable
fun HomeContentScreen(
    homeUiData: HomeUiModel,
    modifier: Modifier = Modifier
) {    // TODO:: think suitable name
    Box(
        modifier = modifier
            .background(color = MainBackgroundColor)
            .fillMaxSize(),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            painter = painterResource(id = dataR.drawable.sample_image_delete_later),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )

        HomeScreenTopBar(
//            modifier = Modifier.statusBarsPadding(),
            userData = HomeScreenTopBarData(
                name = "Good Morning Ed Sheeran",
                subText = "Mon, Feb 12",
                imageUrl = ""
            )
        )

        Text(
            modifier = Modifier.align(alignment = Alignment.Center),
            text = homeUiData.homeSampleTextRemoveLater,
            color = Color.White
        )
    }
}

@ThemePreviews
@Composable
private fun HomeSuccessScreenPreview() {
    HomeContentScreen(homeUiData = HomeUiModel(homeSampleTextRemoveLater = "Preview Text"))
}