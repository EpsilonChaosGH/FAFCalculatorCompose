package com.example.testcompose.ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testcompose.model.MassCostState
import com.example.testcompose.model.Params
import com.example.testcompose.model.ResultState
import com.example.testcompose.ui.theme.RedCybran

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    onNavigateToExp: () -> Unit
) {
//    list: List<ResultState>, params: Params, navController: NavController

    val list = (1..100).map {
        ResultState(
            sacu = it.toString(),
            massIncome = "200",
            time = 15.2.toString(),
            it == 15
        )
    }

    Scaffold(
        bottomBar = {
            ParamsBottomBar(
                massCostState = MassCostState("220000"),
                massIncomeState = MassCostState("150"),
                onNavigateToExp = onNavigateToExp
            )

        }
    ) { innerPadding ->
        ResultsLazyColumn(list, innerPadding)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ResultsLazyColumn(list: List<ResultState>, paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .background(RedCybran)
            .fillMaxSize()
            .padding(paddingValues),

        ) {
        stickyHeader {
            ResultItemTitle()
        }
        items(list) { ResultItem(result = it) }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    val list = (1..100).map {
        ResultState(
            sacu = it.toString(),
            massIncome = "200",
            time = 15.2.toString(),
            it == 15
        )
    }
    val params = Params(
        massCost = 15000,
        massIncome = 200
    )
    // MainScreen(list = list, params = params, navController = navController)
}