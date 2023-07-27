package com.example.testcompose.data.entity

import androidx.room.TypeConverter
import com.example.testcompose.model.SacuCost

class SacuCostConverter {

    @TypeConverter
    fun toSacuCost(value: String) = enumValueOf<SacuCost>(value)

    @TypeConverter
    fun fromSacuCost(value: SacuCost) = value.name
}