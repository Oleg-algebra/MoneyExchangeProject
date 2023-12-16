package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository

class GetCoinUseCase(
    private val repository: Repository
) {
    suspend fun getCurrency(coinName: String): CoinInfo =  repository.getCoin(coinName)
}