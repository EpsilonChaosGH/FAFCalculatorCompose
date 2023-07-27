package com.example.testcompose.ui.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun TestScreen() {

    var text = remember {
        mutableStateOf(11)
    }

    Column {
        Text(text = text.value.toString())
        TextFieldTest(
            numbersTextFieldState = remember { mutableStateOf(22) },
            input = {
                text.value = it
            })
    }
}