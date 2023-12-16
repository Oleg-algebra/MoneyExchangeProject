package com.example.moneyexchwnage.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.moneyexchwnage.data.dataBase.CoinDataBase
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.data.network.ApiFactory
import com.example.moneyexchwnage.data.network.CoinDto
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository

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
            }
        }
    }

    override suspend fun getCoin(coinName: String): CoinInfo {
        return liveData.value?.find { it.coinName == coinName }  ?: CoinInfo()         //FIXME: fix needed

    }

    override suspend fun loadData(){
        val coinDtos = apiService
            .getCurrency(apiKey = key, limit = 10)
            .data
        for (coinDto in coinDtos ?: mutableListOf()){
            addCoin(coinDto)
        }




    }

    override suspend fun addCoin(coinDto: CoinDto) {
        dao.addCoinEntity(mapper.mapDataDtoToEntity(coinDto))
    }

    override suspend fun removeCoin(coinInfo: CoinInfo) {
        //TODO(implement me)

    }



}