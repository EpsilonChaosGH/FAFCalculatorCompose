package com.example.testcompose.model

import com.example.testcompose.model.SacuCost

data class Settings(
    val sacuIncome: Int,
    val sacuCost: SacuCost,
    val secMax: Int,
)