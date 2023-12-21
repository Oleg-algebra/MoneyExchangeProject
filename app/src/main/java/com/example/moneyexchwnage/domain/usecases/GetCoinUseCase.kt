package com.example.moneyexchwnage.domain.usecases

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: Repository
) {
    fun getCurrency(coinName: String): LiveData<CoinInfo> =  repository.getCoin(coinName)
}