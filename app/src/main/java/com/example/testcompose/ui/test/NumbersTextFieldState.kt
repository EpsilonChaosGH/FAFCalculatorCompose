package com.example.testcompose.ui.test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.lang.Exception


class NumbersTextFieldState(val value: String? = "0") {
    var text: String by mutableStateOf("0")

    init {
        value?.let {
            text = it
        }
    }

    val isValid: Boolean
        get() = isNumbersValid(text)

    fun showErrors() = !isValid

    fun getError(): String? {
        return if (showErrors()) {
            "Invalid value"
        } else {
            null
        }
    }

    private fun isNumbersValid(value: String): Boolean {
        return try {
            return value.toInt() >= 0
        } catch (e: Exception) {
            false
        }
    }
}