package com.example.testcompose.ui.screens.exp.views

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testcompose.ui.screens.exp.models.ExpState

@Composable
fun ExpViewDisplay(
    navController: NavController,
    onMassCostClicked: (Int) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 90.dp)
    ) {
        itemsIndexed(ExpState.getList()) { _, exp ->
            ExpItem(exp = exp, navController = navController, onMassCostClicked)
        }
    }
}