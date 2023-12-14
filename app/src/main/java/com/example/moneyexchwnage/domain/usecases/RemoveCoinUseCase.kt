package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository

class RemoveCoinUseCase(
    val repository: Repository
) {
    fun removeCoin(coinInfo: CoinInfo) = repository.removeCoin(coinInfo)
}