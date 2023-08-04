package com.example.testcompose.ui.screens.exp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testcompose.ui.screens.exp.models.ExpState
import com.example.testcompose.ui.theme.AppTheme

@Composable
fun ExpViewDisplay(
    navController: NavController,
    onMassCostClicked: (Int) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 90.dp),
        modifier = Modifier.background(AppTheme.colors.primaryBackground)
            .fillMaxSize(),
    ) {
        itemsIndexed(ExpState.getList()) { _, exp ->
            ExpItem(exp = exp, navController = navController, onMassCostClicked)
        }
    }
}