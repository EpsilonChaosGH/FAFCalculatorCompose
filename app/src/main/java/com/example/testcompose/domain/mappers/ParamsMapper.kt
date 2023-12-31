package com.example.testcompose.domain.mappers

import com.example.testcompose.domain.model.Config
import com.example.testcompose.data.entity.ConfigDbEntity
import com.example.testcompose.utils.Const

fun ConfigDbEntity.toConfig(): Config = Config(
    massCost = massCost,
    massIncome = massIncome,
    sacuIncome = sacuIncome,
    sacuCost = sacuCost,
    secMax = secMax
)

fun Config.toConfigDbEntity(): ConfigDbEntity = ConfigDbEntity(
    keyConfig = Const.KEY_CONFIG,
    massCost = massCost,
    massIncome = massIncome,
    sacuIncome = sacuIncome,
    sacuCost = sacuCost,
    secMax = secMax
)