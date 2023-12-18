package com.example.moneyexchwnage.domain.usecases

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository

class GetCoinUseCase(
    private val repository: Repository
) {
    fun getCurrency(coinName: String): LiveData<CoinInfo> =  repository.getCoin(coinName)
}