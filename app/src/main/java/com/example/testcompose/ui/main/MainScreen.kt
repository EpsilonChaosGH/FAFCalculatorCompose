package com.example.testcompose.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.testcompose.ui.main.models.MainEvent
import com.example.testcompose.ui.main.models.MainViewState
import com.example.testcompose.ui.main.views.MainViewDisplay
import com.example.testcompose.ui.main.views.MainViewLoading

@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    navController: NavController
) {

    val resultList by mainViewModel.resultState.collectAsState(initial = null)

    val config by mainViewModel.configState.collectAsState(initial = null)

    val viewState by mainViewModel.mainViewState.collectAsState()

    when (val state = viewState) {
        is MainViewState.Loading -> MainViewLoading()
        is MainViewState.Display -> MainViewDisplay(
            massCostTextFieldState = remember { mutableStateOf(state.config.massCost) },
            massIncomeTextFieldState = remember { mutableStateOf(state.config.massIncome) },
            onMassCostImeAction = { mainViewModel.obtainEvent(MainEvent.OnMassIncomeChanged(it)) },
            onMassIncomeImeAction = { mainViewModel.obtainEvent(MainEvent.OnMassIncomeChanged(it)) },
            navController = navController,
            resultList = state.results
        )
    }
}