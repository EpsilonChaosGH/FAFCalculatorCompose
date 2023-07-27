package com.example.testcompose.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcompose.EventHandler
import com.example.testcompose.domain.Repository
import com.example.testcompose.domain.mappers.toResultState
import com.example.testcompose.model.Config
import com.example.testcompose.model.Params
import com.example.testcompose.model.ResultState
import com.example.testcompose.model.SacuCost
import com.example.testcompose.ui.main.models.MainEvent
import com.example.testcompose.ui.main.models.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(), EventHandler<MainEvent> {

    private val _resultState = MutableStateFlow<List<ResultState>?>(null)
    val resultState = _resultState.asStateFlow()

    private val _configState = MutableStateFlow<Config?>(null)
    val configState: StateFlow<Config?> = _configState.asStateFlow()

    private val _mainViewState = MutableStateFlow<MainViewState>(MainViewState.Loading)
    val mainViewState = _mainViewState.asStateFlow()

    init {
        _mainViewState.value = MainViewState.Display(
            results = listOf(ResultState("12","12","12" ,false)),
            config = Config(2,2,2,SacuCost.MASS_5320,2)
        )
        viewModelScope.launch {
            listenCurrentResult()
        }

        viewModelScope.launch {
            listenCurrentConfig()
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
            MainEvent.EnterScreen -> fetchHabitForDate(needsToRefresh = true)
            else -> {}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Display) {
        when (event) {
            is MainEvent.OnMassIncomeChanged -> _mainViewState.value = MainViewState.Display(
                results = listOf(ResultState("123","123","123" ,false)),
                config = Config(event.massIncome,event.massIncome,2,SacuCost.MASS_5320,2)
            )
//                saveCurrentParams(
//                Params(
//                    event.massIncome,
//                    event.massIncome
//                )
//            )
            else -> {}
        }
    }

    private fun fetchHabitForDate(needsToRefresh: Boolean = false) {
        if (needsToRefresh) {
            _mainViewState.value = MainViewState.Loading
        }
    }

    private suspend fun listenCurrentResult() {
        repository.getResultFlow().collect { results ->
            _resultState.value = results.map { it.toResultState() }
        }
    }

    private fun listenCurrentConfig() {
        viewModelScope.launch {
            repository.getConfigFlow().collect() {
                _configState.value = it
            }
        }
    }

    private suspend fun listenCurrentState(){
        repository.getResultFlow().collect { results ->
            _resultState.value = results.map { it.toResultState() }
        }
    }

    fun saveCurrentParams(params: Params) {

        _mainViewState.value = MainViewState.Loading

        viewModelScope.launch {
            repository.setCurrentParams(params)
        }
    }
}