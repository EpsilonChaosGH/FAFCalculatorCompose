package com.example.testcompose.ui.screens.exp.models


sealed class ExpEvent {
    data class OnMassCostChanged(val massCost: Int) : ExpEvent()
}
