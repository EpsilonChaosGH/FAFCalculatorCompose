package com.example.testcompose.ui.settings.models

import com.example.testcompose.model.Config

sealed class SettingsViewState {
    object Loading : SettingsViewState()
    data class Display(val config: Config) : SettingsViewState()
}
