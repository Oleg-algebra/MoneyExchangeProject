package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.domain.Repository

class GetCurrency(
    private val repository: Repository
) {
    fun getCurrency(id: Long): CoinName =  repository.getCurrency(id)
}