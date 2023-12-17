package com.example.moneyexchwnage.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.moneyexchwnage.data.dataBase.CoinDataBase
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.data.network.ApiFactory
import com.example.moneyexchwnage.data.network.CoinDetailedInfo
import com.example.moneyexchwnage.data.workers.RefreshDataWorker
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository

class RepositoryImpl(val application: Application): Repository {
    val liveData = MutableLiveData<List<CoinInfo>>()
    val baseURL = "https://min-api.cryptocompare.com/"
    val key = "dd45fcdbbfa53e9a17e9405fc88cb11dd3ccc2c69a772b9fb4ede412249afab1"
    val apiService = ApiFactory(baseURL).service
    val mapper = Mapper()
    private val dao = CoinDataBase.getDatabase(application).coinDao()

    override fun getCurrencyList(): LiveData<List<CoinInfo>> {
        return MediatorLiveData<List<CoinInfo>>().apply {
            addSource(dao.getListEntities()){
                value = mapper.mapEntitiesToCoinsInfos(it)
                    .sortedByDescending { it.coinPrice }
//                Log.d(TAG, "getCurrencyList: $value")
            }
        }

    }

    override suspend fun getCoin(coinName: String): CoinInfo {
        return liveData.value
            ?.find { it.coinName == coinName }  ?: CoinInfo()         //FIXME: fix needed

    }

    override fun loadData(){
     val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )





    }

    override suspend fun addCoin(detailedInfo: CoinDetailedInfo) {
        val entity = mapper.mapDataDtoToEntity(detailedInfo)
//        Log.d(TAG, "addCoinEntity: ${entity.imageUrl}")
        if (entity.coinName.isNotEmpty()) {
            dao.addCoinEntity(entity)
        }
    }

    override suspend fun removeCoin(coinInfo: CoinInfo) {
        //TODO(implement me)

    }



}