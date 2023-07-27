package com.example.testcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testcompose.data.dao.ConfigDao
import com.example.testcompose.data.entity.ConfigDbEntity
import com.example.testcompose.data.entity.SacuCostConverter

@Database(
    entities = [
        ConfigDbEntity::class
    ], version = 1
)
@TypeConverters(SacuCostConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun configDao(): ConfigDao
}