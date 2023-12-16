package com.example.moneyexchwnage.domain

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.data.network.CoinDto

interface Repository {

    fun getCurrencyList(): LiveData<List<CoinInfo>>
    suspend fun getCoin(coinName: String): CoinInfo
    suspend fun loadData()
    suspend fun removeCoin(coinInfo: CoinInfo)

    suspend fun addCoin(coinDto: CoinDto)



}