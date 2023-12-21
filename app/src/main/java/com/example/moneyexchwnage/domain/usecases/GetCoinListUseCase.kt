package com.example.moneyexchwnage.domain.usecases

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(
    private val repository: Repository
) {
    fun getCurrencyList(): LiveData<List<CoinInfo>>{
        return repository.getCurrencyList()
    }
}