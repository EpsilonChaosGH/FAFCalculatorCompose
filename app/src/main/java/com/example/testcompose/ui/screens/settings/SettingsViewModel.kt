package com.example.testcompose.ui.screens.settings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcompose.utils.EventHandler
import com.example.testcompose.domain.Repository
import com.example.testcompose.domain.model.Config
import com.example.testcompose.ui.screens.settings.models.SettingsEvent
import com.example.testcompose.ui.screens.settings.models.SettingsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(), EventHandler<SettingsEvent> {

    private val _settingsViewState = MutableStateFlow<SettingsViewState>(SettingsViewState.Loading)
    val settingsViewState = _settingsViewState.asStateFlow()

    init {
        viewModelScope.launch {
            listenConfig()
        }
    }

    override fun obtainEvent(event: SettingsEvent) {
        when (val state = settingsViewState.value) {
            is SettingsViewState.Loading -> {}
            is SettingsViewState.Display -> reduce(event, state)
        }
    }

    private fun reduce(event: SettingsEvent, currentState: SettingsViewState.Display) {
        when (event) {
            is SettingsEvent.OnSacuCostChanged -> setConfig(
                currentState.config.copy(
                    sacuCost = event.sacuCost
                )
            )

            else -> {}
        }
    }

    private fun setConfig(config: Config) {
        viewModelScope.launch {
            repository.setConfig(config)
        }
    }

    private fun listenConfig() {
        viewModelScope.launch {
            repository.getConfigFlow().collect() {
                Log.e("QWERTY  VM", it.sacuCost.mass.toString())
                _settingsViewState.value = SettingsViewState.Display(it)
            }
        }
    }
}