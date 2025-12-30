package com.shivam.gaanaartist

import com.shivam.gaanaartist.core.model.data.MainData

sealed interface MainActivityUiState {

    data object Loading : MainActivityUiState

    data class Success(val data: MainData) : MainActivityUiState

    data class Error(val message: String) : MainActivityUiState

}