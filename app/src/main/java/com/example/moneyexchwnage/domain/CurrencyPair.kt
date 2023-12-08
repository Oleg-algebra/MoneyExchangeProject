package com.example.moneyexchwnage.domain

data class CurrencyPair(
    val firstCurrencyID: Long = UNDEFINED_ID,
    val secondCurrencyID: Long = UNDEFINED_ID,
    val rate: Double,
    var frequencyUpdate: Int = FREQ_UPDATE,
    val id: Long = UNDEFINED_ID,
)
