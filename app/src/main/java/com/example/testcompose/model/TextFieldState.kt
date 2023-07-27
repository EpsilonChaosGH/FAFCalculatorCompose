package com.example.testcompose.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue

open class TextFieldState(
    private val validator: (String) -> Boolean = { true },
    private val errorFor: () -> String = { "" }
) {
    var text: String by mutableStateOf("0")

    open val isValid: Boolean
        get() = validator(text)

    fun showErrors() = !isValid

    open fun getError(): String? {
        return if (showErrors()) {
            errorFor()
        } else {
            null
        }
    }
}
