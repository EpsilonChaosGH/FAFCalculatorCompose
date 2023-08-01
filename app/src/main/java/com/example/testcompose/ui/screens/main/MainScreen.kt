package com.example.testcompose.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.testcompose.ui.screens.main.models.MainEvent
import com.example.testcompose.ui.screens.main.models.MainViewState
import com.example.testcompose.ui.screens.main.views.MainViewDisplay
import com.example.testcompose.ui.screens.main.views.MainViewLoading

@Composable
fun MainScreen(
    modifier: Modifier,
    mainViewModel: MainViewModel,
) {

    val viewState by mainViewModel.mainViewState.collectAsState()

    when (val state = viewState) {
        is MainViewState.Loading -> MainViewLoading()
        is MainViewState.Display -> MainViewDisplay(
            modifier = modifier,
            viewState = state,
            onMassCostImeAction = { mainViewModel.obtainEvent(MainEvent.OnMassCostChanged(it)) },
            onMassIncomeImeAction = { mainViewModel.obtainEvent(MainEvent.OnMassIncomeChanged(it)) },
            resultList = state.results
        )
    }
}