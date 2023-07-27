package com.example.testcompose.model

import java.lang.Exception


class MassCostState(val massCost: String? = "0") :
    TextFieldState(validator = ::isMassCostValid, errorFor = ::massCostValidationError) {
    init {
        massCost?.let {
            text = it
        }
    }
}

/**
 * Returns an error to be displayed or null if no error was found
 */
private fun massCostValidationError(): String {
    return "Invalid mass cost"
}

private fun isMassCostValid(massCost: String): Boolean {
    return try {
        return massCost.toInt() >= 0
    } catch (e: Exception){
        false
    }
}
