package com.example.moneyexchwnage.data.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.moneyexchwnage.data.dataBase.CoinDataBase
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.data.network.ApiFactory
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import kotlinx.coroutines.delay

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    private val coinInfoDao = CoinDataBase.getDatabase(context).coinDao()
    private val apiService = ApiFactory(BASE_URL).service
    private val mapper = Mapper()
    private val key = "dd45fcdbbfa53e9a17e9405fc88cb11dd3ccc2c69a772b9fb4ede412249afab1"


    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getCurrency(limit = 50, apiKey = key)
                val fSyms = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSyms, apiKey = key)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val coinEntityList = coinInfoDtoList.map { mapper.mapDataDtoToEntity(it) }
                coinInfoDao.insertPriceList(coinEntityList)
            } catch (e: Exception) {
                Log.e(TAG, "doWork: $e" )
            }
            delay(1000 * 10)
        }
    }

    companion object {

        const val NAME = "RefreshDataWorker"
        const val BASE_URL = "https://min-api.cryptocompare.com/"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }
}