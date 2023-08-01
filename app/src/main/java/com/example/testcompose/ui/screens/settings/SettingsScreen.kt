package com.example.testcompose.ui.screens.settings


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.testcompose.ui.screens.settings.models.SettingsEvent
import com.example.testcompose.ui.screens.settings.models.SettingsViewState
import com.example.testcompose.ui.screens.settings.views.SettingsViewDisplay
import com.example.testcompose.ui.screens.settings.views.SettingsViewLoading

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel
) {
    val viewState by settingsViewModel.settingsViewState.collectAsState()

    when (val state = viewState) {
        is SettingsViewState.Loading -> SettingsViewLoading()
        is SettingsViewState.Display -> {
            SettingsViewDisplay(
                viewState = state,
                onSacuCostChanged = {
                    settingsViewModel.obtainEvent(SettingsEvent.OnSacuCostChanged(it))
                }
            )
        }
    }
}