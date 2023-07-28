package com.example.testcompose.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcompose.EventHandler
import com.example.testcompose.domain.Repository
import com.example.testcompose.model.Config
import com.example.testcompose.ui.settings.models.SettingsEvent
import com.example.testcompose.ui.settings.models.SettingsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
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
            listenCurrentConfig()
        }
    }

    override fun obtainEvent(event: SettingsEvent) {
        when (val state = settingsViewState.value) {
            is SettingsViewState.Loading -> reduce(event, state)
            is SettingsViewState.Display -> reduce(event, state)
        }
    }

    private fun reduce(event: SettingsEvent, currentState: SettingsViewState.Loading) {
        when (event) {
            SettingsEvent.EnterScreen -> {}
            else -> {}
        }
    }

    private fun reduce(event: SettingsEvent, currentState: SettingsViewState.Display) {
        when (event) {
            is SettingsEvent.OnSacuCostChanged -> setCurrentConfig(
                currentState.config.copy(
                    sacuCost = event.sacuCost
                )
            )

            else -> {}
        }
    }

    private fun setCurrentConfig(config: Config) {
        viewModelScope.launch {
            repository.setConfig(config)
        }
    }

    private fun listenCurrentConfig() {
        viewModelScope.launch {
            repository.getConfigFlow().collect() {
                _settingsViewState.value = SettingsViewState.Display(it)
            }
        }
    }

}