package com.example.testcompose.domain

import com.example.testcompose.model.Config
import com.example.testcompose.model.Params
import com.example.testcompose.model.ResultEntity
import com.example.testcompose.model.Settings
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getResultFlow(): Flow<List<ResultEntity>>

    suspend fun getConfigFlow(): Flow<Config>

    suspend fun setCurrentParams(params: Params)

    suspend fun setCurrentSettings(settings: Settings)

    suspend fun setCost(cost: Int)
}