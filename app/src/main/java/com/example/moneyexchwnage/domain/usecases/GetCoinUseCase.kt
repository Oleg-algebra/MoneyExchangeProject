package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository

class GetCoinUseCase(
    private val repository: Repository
) {
    fun getCurrency(id: Long): CoinInfo =  repository.getCurrency(id)
}