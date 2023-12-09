package com.example.moneyexchwnage.domain.usecases

import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.Repository

class GetCurrencyList(
    private val repository: Repository
) {
    fun getCurrencyList(): LiveData<List<Currency>>{
        return repository.getCurrencyList()
    }
}