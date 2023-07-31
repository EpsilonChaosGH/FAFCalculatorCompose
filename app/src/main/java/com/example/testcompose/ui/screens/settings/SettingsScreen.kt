package com.example.testcompose.ui.screens.settings


import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.testcompose.ui.screens.settings.models.SettingsEvent
import com.example.testcompose.ui.screens.settings.models.SettingsViewState
import com.example.testcompose.ui.screens.settings.views.SettingsViewDisplay
import com.example.testcompose.ui.screens.settings.views.SettingsViewLoading

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel
) {
    Log.e("QWERTY11","SET SCR")
    val viewState by settingsViewModel.settingsViewState.collectAsState()

    when (val state = viewState) {
        is SettingsViewState.Loading -> SettingsViewLoading()
        is SettingsViewState.Display -> SettingsViewDisplay(
            config = remember { mutableStateOf(state.config) },
            onSacuCostChanged = { settingsViewModel.obtainEvent(SettingsEvent.OnSacuCostChanged(it)) }
        )
    }

    LaunchedEffect(key1 = viewState, block = {
        settingsViewModel.obtainEvent(SettingsEvent.EnterScreen)
    })
}