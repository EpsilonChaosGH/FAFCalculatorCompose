package com.example.testcompose.ui.screens.settings.models

import com.example.testcompose.domain.model.SacuCost

sealed class SettingsEvent {

    data class OnSacuCostChanged(val sacuCost: SacuCost) : SettingsEvent()
}
