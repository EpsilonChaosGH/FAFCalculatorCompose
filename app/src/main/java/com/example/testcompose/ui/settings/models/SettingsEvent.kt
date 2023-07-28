package com.example.testcompose.ui.settings.models

import com.example.testcompose.model.SacuCost

sealed class SettingsEvent {
    object EnterScreen : SettingsEvent()
    data class OnSacuCostChanged(val sacuCost: SacuCost) : SettingsEvent()
}
