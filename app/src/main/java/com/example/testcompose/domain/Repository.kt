package com.example.testcompose.domain

import com.example.testcompose.domain.model.Config
import com.example.testcompose.domain.model.Params
import com.example.testcompose.ui.screens.main.models.MainViewState
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getResultFlow(): Flow<MainViewState.Display>

    suspend fun getConfigFlow(): Flow<Config>

    suspend fun setConfig(config: Config)

    suspend fun setMassCost(massCost: Int)

    suspend fun setParams(params: Params)

}