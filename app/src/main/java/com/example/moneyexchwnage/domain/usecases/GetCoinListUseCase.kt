package com.example.moneyexchwnage.domain.usecases

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository

class GetCoinListUseCase(
    private val repository: Repository
) {
    fun getCurrencyList(): LiveData<List<CoinInfo>>{
        return repository.getCurrencyList()
    }
}