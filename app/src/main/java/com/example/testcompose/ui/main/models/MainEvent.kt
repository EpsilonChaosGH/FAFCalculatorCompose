package com.example.testcompose.ui.main.models

sealed class MainEvent {
    object EnterScreen : MainEvent()
    data class OnMassIncomeChanged(val massIncome: Int) : MainEvent()
}
