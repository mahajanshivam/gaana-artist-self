package com.shivam.gaanaartist.feature.home.impl

import com.shivam.gaanaartist.core.model.data.HomeUiModel

sealed interface HomeUiState {

    data object Loading : HomeUiState

    data class Success(
        val homeUiData: HomeUiModel
    ) : HomeUiState
}