package com.example.testcompose.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.testcompose.ui.screens.main.models.MainEvent
import com.example.testcompose.ui.screens.main.models.MainViewState
import com.example.testcompose.ui.screens.main.views.MainViewDisplay
import com.example.testcompose.ui.screens.main.views.MainViewLoading

@Composable
fun MainScreen(
    modifier: Modifier,
    mainViewModel: MainViewModel,
    navController: NavController
) {


    val viewState by mainViewModel.mainViewState.collectAsState()

    when (val state = viewState) {
        is MainViewState.Loading -> MainViewLoading()
        is MainViewState.Display -> MainViewDisplay(
            modifier = modifier,
            massCostTextFieldState = remember { mutableStateOf(state.config.massCost) },
            massIncomeTextFieldState = remember { mutableStateOf(state.config.massIncome) },
            onMassCostImeAction = { mainViewModel.obtainEvent(MainEvent.OnMassCostChanged(it)) },
            onMassIncomeImeAction = { mainViewModel.obtainEvent(MainEvent.OnMassIncomeChanged(it)) },
            navController = navController,
            resultList = state.results
        )

    }
    LaunchedEffect(key1 = viewState, block = {
        mainViewModel.obtainEvent(event = MainEvent.EnterScreen)
    })
}