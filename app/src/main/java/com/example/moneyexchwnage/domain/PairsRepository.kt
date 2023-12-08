package com.example.moneyexchwnage.domain

interface PairsRepository {

    fun addCurrencyPair(pair: CurrencyPair)
    fun removeCurrencyPair(pair: CurrencyPair)
    fun getAllPairs(): List<CurrencyPair>

}