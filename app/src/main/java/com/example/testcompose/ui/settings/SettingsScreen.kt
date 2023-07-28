package com.example.testcompose.ui.settings


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.testcompose.ui.settings.models.SettingsEvent
import com.example.testcompose.ui.settings.models.SettingsViewState
import com.example.testcompose.ui.settings.views.SettingsView
import com.example.testcompose.ui.settings.views.SettingsViewLoading

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel
) {

    val viewState by settingsViewModel.settingsViewState.collectAsState()

    when (val state = viewState) {
        is SettingsViewState.Loading -> SettingsViewLoading()
        is SettingsViewState.Display -> SettingsView(
            config = remember { mutableStateOf(state.config) },
            onSacuCostChanged = { settingsViewModel.obtainEvent(SettingsEvent.OnSacuCostChanged(it)) }
        )
    }

    LaunchedEffect(key1 = viewState, block = {
        settingsViewModel.obtainEvent(SettingsEvent.EnterScreen)
    })
}