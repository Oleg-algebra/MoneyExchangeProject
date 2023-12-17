package com.example.moneyexchwnage.data.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.moneyexchwnage.data.dataBase.CoinDataBase
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.data.network.ApiFactory
import kotlinx.coroutines.delay

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    private val coinInfoDao = CoinDataBase.getDatabase(context).coinDao()
    private val apiService = ApiFactory(BASE_URL).service
    private val mapper = Mapper()


    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getCurrency(limit = 50)
                val fSyms = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSyms)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDataDtoToEntity(it) }
                for(entity in dbModelList){
                    coinInfoDao.addCoinEntity(entity)
                }
            } catch (e: Exception) {
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