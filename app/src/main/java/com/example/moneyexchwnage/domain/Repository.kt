package com.example.moneyexchwnage.domain

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.data.network.model.CoinDetailedInfo

interface Repository {

    fun getCurrencyList(): LiveData<List<CoinInfo>>
   fun getCoin(coinName: String): LiveData<CoinInfo>
    fun loadData()
    suspend fun removeCoin(coinInfo: CoinInfo)
}