package com.example.testcompose.domain.model


data class Config(
    val massCost: Int = 0,
    val massIncome: Int = 0,
    val sacuIncome: Int = 11,
    val sacuCost: SacuCost = SacuCost.MASS_6450,
    val secMax: Int = 1500,
)

