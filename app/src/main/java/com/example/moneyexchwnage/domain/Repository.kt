package com.example.moneyexchwnage.domain

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.data.network.RequestDtoObject

interface Repository {

    fun getCurrencyList(): LiveData<List<CoinName>>
    fun getCurrency(id: Long): CoinName
    fun loadData()

}