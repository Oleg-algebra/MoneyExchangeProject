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
import com.example.moneyexchwnage.data.network.model.CoinDetailedInfo
import com.example.moneyexchwnage.data.workers.RefreshDataWorker
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository
import java.lang.RuntimeException

class RepositoryImpl(val application: Application): Repository {
    val liveData = MutableLiveData<List<CoinInfo>>()
    val mapper = Mapper()
    private val dao = CoinDataBase.getDatabase(application).coinDao()

    override fun getCurrencyList(): LiveData<List<CoinInfo>> {
        return MediatorLiveData<List<CoinInfo>>().apply {
            addSource(dao.getListEntities()){
                value = mapper.mapEntitiesToCoinsInfos(it)
                    .sortedByDescending { it.coinPrice }
            }
        }

    }

    override suspend fun getCoin(coinName: String): CoinInfo {
        return liveData.value
            ?.find { it.coinName == coinName }
            ?: throw RuntimeException("Coin $coinName not found.")

    }

    override fun loadData(){
     val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }

    override suspend fun removeCoin(coinInfo: CoinInfo) {
        //TODO(implement me)

    }



}