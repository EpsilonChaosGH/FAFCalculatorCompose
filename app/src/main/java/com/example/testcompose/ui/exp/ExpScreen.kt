package com.example.testcompose.ui.exp

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.model.ExpState

@Preview(showBackground = true)
@Composable
fun ExpScreen() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 90.dp)
    ) {
        itemsIndexed(ExpState.getList()) { _, exp ->
            ExpItem(exp = exp)
        }
    }
}