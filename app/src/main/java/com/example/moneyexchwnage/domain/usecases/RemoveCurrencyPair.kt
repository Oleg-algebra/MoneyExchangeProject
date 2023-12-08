package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.CurrencyPair
import com.example.moneyexchwnage.domain.PairsRepository

class RemoveCurrencyPair(
    private val repository: PairsRepository
) {
    fun removePair(currencyPair: CurrencyPair){
        repository.removeCurrencyPair(currencyPair)
    }
}