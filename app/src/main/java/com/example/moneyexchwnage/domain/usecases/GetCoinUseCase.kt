package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository

class GetCoinUseCase(
    private val repository: Repository
) {
    suspend fun getCurrency(coinname: String): CoinInfo =  repository.getCoin(coinname)
}