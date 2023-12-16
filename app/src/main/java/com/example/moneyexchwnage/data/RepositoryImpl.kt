package com.example.moneyexchwnage.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.moneyexchwnage.data.dataBase.CoinDataBase
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.data.network.ApiFactory
import com.example.moneyexchwnage.data.network.CoinDto
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import kotlin.math.log

class RepositoryImpl(context: Context): Repository {
    val liveData = MutableLiveData<List<CoinInfo>>()
    val baseURL = "https://min-api.cryptocompare.com/"
    val key = "dd45fcdbbfa53e9a17e9405fc88cb11dd3ccc2c69a772b9fb4ede412249afab1"
    val apiService = ApiFactory(baseURL).service
    val mapper = Mapper()
    private val dao = CoinDataBase.getDatabase(context).coinDao()

    override fun getCurrencyList(): LiveData<List<CoinInfo>> {
        return MediatorLiveData<List<CoinInfo>>().apply {
            addSource(dao.getListEntities()){
                value = mapper.mapEntitiesToCoinsInfos(it)
//                Log.d(TAG, "getCurrencyList: $value")
            }
        }
//        return liveData.apply {
//            val entities = dao.getListEntities().value
//            Log.d(TAG, "getCurrencyList: ${dao.getListEntities().value}")
//            value = mapper.mapEntitiesToCoinsInfos(entities ?: mutableListOf())
//        }
    }

    override suspend fun getCoin(coinName: String): CoinInfo {
        return liveData.value?.find { it.coinName == coinName }  ?: CoinInfo()         //FIXME: fix needed

    }

    override suspend fun loadData(){
        dao.clearTable()
        val coinDtos = apiService
            .getCurrency(apiKey = key, limit = 10)
            .data
//        Log.d(TAG, "loadData:$coinDtos ")
        for (coinDto in coinDtos ?: mutableListOf()){
            addCoin(coinDto)
        }
        getCurrencyList()




    }

    override suspend fun addCoin(coinDto: CoinDto) {
        val entity = mapper.mapDataDtoToEntity(coinDto)
//        Log.d(TAG, "addCoinEntity: ${entity.imageUrl}")
        if (entity.coinName.isNotEmpty()) {
            dao.addCoinEntity(entity)
        }
    }

    override suspend fun removeCoin(coinInfo: CoinInfo) {
        //TODO(implement me)

    }



}