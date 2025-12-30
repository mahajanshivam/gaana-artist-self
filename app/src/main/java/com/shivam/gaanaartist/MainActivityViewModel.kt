package com.shivam.gaanaartist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivam.gaanaartist.core.model.data.MainData
import com.shivam.gaanaartist.MainActivityUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<MainActivityUiState> =
        MutableStateFlow(MainActivityUiState.Loading)

    val uiState: StateFlow<MainActivityUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3_000)
            _uiState.value = MainActivityUiState.Success(MainData("Main Activity Data"))
        }
    }

}