package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.CurrencyPair
import com.example.moneyexchwnage.domain.PairsRepository

class GetAllPairs(
    private val pairsRepository: PairsRepository
) {
    fun getAllPairs(): List<CurrencyPair>{
        return pairsRepository.getAllPairs()
    }
}