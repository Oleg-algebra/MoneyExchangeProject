package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository
import javax.inject.Inject

class RemoveCoinUseCase @Inject constructor(
    val repository: Repository
) {
    suspend fun removeCoin(coinInfo: CoinInfo) = repository.removeCoin(coinInfo)
}