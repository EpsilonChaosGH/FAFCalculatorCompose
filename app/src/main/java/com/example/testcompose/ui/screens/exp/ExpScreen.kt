package com.example.testcompose.ui.screens.exp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.testcompose.ui.screens.exp.models.ExpEvent
import com.example.testcompose.ui.screens.exp.models.ExpViewState
import com.example.testcompose.ui.screens.exp.views.ExpViewDisplay


@Composable
fun ExpScreen(
    navController: NavController,
    expViewModel: ExpViewModel
) {
    val viewState by expViewModel.expViewState.collectAsState()

    when (viewState) {
        is ExpViewState.Display -> ExpViewDisplay(
            navController = navController,
            onMassCostClicked = { expViewModel.obtainEvent(ExpEvent.OnMassCostChanged(it)) }
        )
    }
}