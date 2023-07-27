package com.example.testcompose.domain.mappers

import com.example.testcompose.model.Config
import com.example.testcompose.data.entity.ConfigDbEntity

fun ConfigDbEntity.toConfig(): Config = Config(
    massCost = massCost,
    massIncome = massIncome,
    sacuIncome = sacuIncome,
    sacuCost = sacuCost,
    secMax = secMax
)