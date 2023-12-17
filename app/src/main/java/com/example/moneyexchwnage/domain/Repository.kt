package com.example.moneyexchwnage.domain

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.data.network.model.CoinDetailedInfo

interface Repository {

    fun getCurrencyList(): LiveData<List<CoinInfo>>
    suspend fun getCoin(coinName: String): CoinInfo
    fun loadData()
    suspend fun removeCoin(coinInfo: CoinInfo)
}