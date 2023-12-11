package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.domain.Repository

class AddCurrency(
    private val repository: Repository
) {
    fun addCurrency(coinName: CoinName){
        repository.addCurrency(coinName)
    }
}