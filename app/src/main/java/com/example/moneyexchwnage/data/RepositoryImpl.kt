package com.example.moneyexchwnage.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.moneyexchwnage.data.dataBase.CoinDao
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.data.workers.RefreshDataWorker
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
                    val application: Application,
                    val mapper: Mapper,
                    val dao : CoinDao
): Repository {


    override fun getCurrencyList(): LiveData<List<CoinInfo>> {
        return MediatorLiveData<List<CoinInfo>>().apply {
            addSource(dao.getListEntities()){
                value = mapper.mapEntitiesToCoinsInfos(it)
                    .sortedByDescending { it.coinPrice }
            }
        }

    }

    override fun getCoin(coinName: String): LiveData<CoinInfo> {
        return MediatorLiveData<CoinInfo>().apply {
            addSource(dao.getEntity(coinName)){
                Log.d(TAG, "getCoin live data: $it")
                value = mapper.mapEntityToCoinInfo(it)
            }
        }

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