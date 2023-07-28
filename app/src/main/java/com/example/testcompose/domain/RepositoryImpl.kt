package com.example.testcompose.domain


import com.example.testcompose.domain.mappers.toConfig
import com.example.testcompose.data.AppDatabase
import com.example.testcompose.data.entity.UpdateParamsTuple
import com.example.testcompose.domain.mappers.toConfigDbEntity
import com.example.testcompose.domain.mappers.toResultState
import com.example.testcompose.model.Config
import com.example.testcompose.model.Const
import com.example.testcompose.model.Params
import com.example.testcompose.model.ResultEntity
import com.example.testcompose.ui.main.models.MainViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase,
) : Repository {
    override suspend fun getResultFlow(): Flow<MainViewState.Display> {
        return appDatabase.configDao().getConfigFlow(Const.KEY_CONFIG).map {
            val config = it.toConfig()
            val result = getResult(config).map { it.toResultState() }
            MainViewState.Display(result, config)
        }
    }

    override suspend fun setParams(params: Params) {
        appDatabase.configDao().updateParams(
            UpdateParamsTuple(
                keyConfig = Const.KEY_CONFIG,
                massCost = params.massCost,
                massIncome = params.massIncome
            )
        )
    }

    override suspend fun setConfig(config: Config) = withContext(Dispatchers.Default) {
        appDatabase.configDao().insertConfig(config.toConfigDbEntity())
    }

    override suspend fun getConfigFlow(): Flow<Config> {
        return appDatabase.configDao().getConfigFlow(Const.KEY_CONFIG).map { it.toConfig() }
    }

    private fun getResult(config: Config): List<ResultEntity> {

        val resultList: MutableList<ResultEntity> = ArrayList()
        val massCost = config.massCost
        var massIncome = config.massIncome
        var massCurrent = 0
        var sec = 0
        val secMax = config.secMax //1200
        var sacu = 0
        val sacuCost = config.sacuCost.mass //6450-5320
        val sacuIncome = config.sacuIncome
        var bestResultIndex = 0

        fun currentTime(): Int {
            return sec + (massCost / massIncome)
        }

        var bestResult = currentTime()

        fun resultAll(sacu: Int, massIncome: Int) {
            resultList.add(
                sacu,
                ResultEntity(sacu, massIncome, currentTime(), false)
            )
            if (currentTime() < bestResult) {
                bestResult = currentTime()
                bestResultIndex = sacu
            }
        }

        resultAll(0, massIncome)

        while (sec < secMax) {
            massCurrent += massIncome
            sec++
            if (massCurrent >= sacuCost) {
                sacu++
                massIncome += sacuIncome
                massCurrent -= sacuCost
                resultAll(sacu, massIncome)
            }
        }

        resultList[bestResultIndex] = resultList[bestResultIndex].copy(best = true)
        return resultList
    }
}