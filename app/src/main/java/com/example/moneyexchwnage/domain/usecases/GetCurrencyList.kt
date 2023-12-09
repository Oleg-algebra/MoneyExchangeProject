package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.Repository

class GetCurrencyList(
    private val repository: Repository
) {
    fun getCurrencyList(): List<Currency>{
        return repository.getCurrencyList()
    }
}