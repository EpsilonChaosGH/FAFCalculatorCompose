package com.example.testcompose.ui.screens.settings.models

import com.example.testcompose.domain.model.Config

sealed class SettingsViewState {
    object Loading : SettingsViewState()
    data class Display(val config: Config) : SettingsViewState()
}
