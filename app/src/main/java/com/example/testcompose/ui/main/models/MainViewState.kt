package com.example.testcompose.ui.main.models

import com.example.testcompose.model.Config
import com.example.testcompose.model.ResultState

sealed class MainViewState {
    object Loading : MainViewState()
    data class Display(
        val results: List<ResultState>,
        val config: Config
    ) : MainViewState()
}
