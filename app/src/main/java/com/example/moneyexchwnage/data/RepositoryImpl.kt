package com.example.moneyexchwnage.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.data.network.ApiFactory
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import kotlinx.coroutines.delay
import kotlin.coroutines.coroutineContext

object RepositoryImpl: Repository {
    var currenciesList = mutableListOf<CoinInfo>()
    val liveData = MutableLiveData<List<CoinInfo>>()
    val baseURL = "https://min-api.cryptocompare.com/"
    val key = "dd45fcdbbfa53e9a17e9405fc88cb11dd3ccc2c69a772b9fb4ede412249afab1"
    val apiService = ApiFactory(baseURL).service
    val mapper = Mapper()

    override fun getCurrencyList(): LiveData<List<CoinInfo>> {
        return liveData.apply {
            update()
        }
    }

    override fun getCurrency(id: Long): CoinInfo {
        return CoinInfo()           //FIXME: fix needed

    }

    override suspend fun loadData(){
        val dataDtoObject = apiService.getCurrency(apiKey = key, limit = 10)
        val newList = mutableListOf<CoinInfo>()
        for(coinDto in dataDtoObject.data?: mutableListOf()){
            val coinInfo = mapper.mapDataDtoToCoin(coinDto)
            newList.add(coinInfo)
        }
        currenciesList = newList
        update()
        delay(1000*12)

    }

    override fun removeCoin(coinInfo: CoinInfo) {
        currenciesList.remove(coinInfo)
        update()
    }

    fun update(){
        liveData.value = currenciesList.toList()
        Log.d(TAG, "update: list length ${currenciesList.size}")
    }


}