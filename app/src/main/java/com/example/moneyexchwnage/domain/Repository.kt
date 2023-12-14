package com.example.moneyexchwnage.domain

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.data.network.DataDtoObject

interface Repository {

    fun getCurrencyList(): LiveData<List<CoinInfo>>
    fun getCurrency(id: Long): CoinInfo
    suspend fun loadData()
    fun removeCoin(coinInfo: CoinInfo)

}