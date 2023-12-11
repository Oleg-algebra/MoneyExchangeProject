package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.domain.Repository

class RemoveCurrency(
    private val repository: Repository
) {
    fun removeCurrency(coinName: CoinName){
        repository.removeCurrency(coinName)
    }
}