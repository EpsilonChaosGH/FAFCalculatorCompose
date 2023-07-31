package com.example.testcompose.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcompose.utils.EventHandler
import com.example.testcompose.domain.Repository
import com.example.testcompose.domain.model.Params
import com.example.testcompose.ui.screens.main.models.MainEvent
import com.example.testcompose.ui.screens.main.models.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(), EventHandler<MainEvent> {

    private val _mainViewState = MutableStateFlow<MainViewState>(MainViewState.Loading)
    val mainViewState = _mainViewState.asStateFlow()

    init {
        viewModelScope.launch {
            listenCurrentState()
        }
    }

    override fun obtainEvent(event: MainEvent) {
        when (val state = mainViewState.value) {
            is MainViewState.Loading -> reduce(event, state)
            is MainViewState.Display -> reduce(event, state)
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Loading) {
        when (event) {
            MainEvent.EnterScreen -> {}
            else -> {}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Display) {
        when (event) {
            is MainEvent.OnMassCostChanged ->
                saveCurrentParams(
                    Params(
                        massCost = event.massCost,
                        massIncome = currentState.config.massIncome
                    )
                )

            is MainEvent.OnMassIncomeChanged ->
                saveCurrentParams(
                    Params(
                        massCost = currentState.config.massCost,
                        massIncome = event.massIncome
                    )
                )

            else -> {}
        }
    }

    private suspend fun listenCurrentState() {
        repository.getResultFlow().collect { results ->
            _mainViewState.value = results
        }
    }

    private fun saveCurrentParams(params: Params) {
        viewModelScope.launch {
            repository.setParams(params)
        }
    }
}