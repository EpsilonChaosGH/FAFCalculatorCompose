package com.example.testcompose.ui.screens.exp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcompose.utils.EventHandler
import com.example.testcompose.domain.Repository
import com.example.testcompose.ui.screens.exp.models.ExpEvent
import com.example.testcompose.ui.screens.exp.models.ExpViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(), EventHandler<ExpEvent> {

    private val _expViewState = MutableStateFlow<ExpViewState>(ExpViewState.Display)
    val expViewState = _expViewState.asStateFlow()

    override fun obtainEvent(event: ExpEvent) {
        when (val state = expViewState.value) {
            is ExpViewState.Display -> reduce(event, state)
        }
    }

    private fun reduce(event: ExpEvent, currentState: ExpViewState.Display) {
        when (event) {
            is ExpEvent.OnMassCostChanged -> setMassCost(event.massCost)
        }
    }

    private fun setMassCost(massCost: Int) {
        viewModelScope.launch {
            repository.setMassCost(massCost)
        }
    }
}