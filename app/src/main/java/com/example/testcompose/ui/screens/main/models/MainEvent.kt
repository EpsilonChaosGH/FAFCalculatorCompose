package com.example.testcompose.ui.screens.main.models

sealed class MainEvent {
    data class OnMassCostChanged(val massCost: Int) : MainEvent()
    data class OnMassIncomeChanged(val massIncome: Int) : MainEvent()
}
