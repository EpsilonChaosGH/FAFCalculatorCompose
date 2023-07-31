package com.example.testcompose.ui.screens.main.models

import com.example.testcompose.domain.model.Config
import com.example.testcompose.domain.model.ResultState

sealed class MainViewState {
    object Loading : MainViewState()
    data class Display(
        val results: List<ResultState>,
        val config: Config
    ) : MainViewState()
}
