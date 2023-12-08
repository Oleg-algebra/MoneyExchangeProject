package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.CurrencyPair
import com.example.moneyexchwnage.domain.PairsRepository

class AddCurrencyPair(
    private val pairsRepository: PairsRepository
) {
    fun addPair(currencyPair: CurrencyPair){
        pairsRepository.addCurrencyPair(currencyPair)
    }
}