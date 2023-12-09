package com.example.moneyexchwnage.domain

data class Currency(
    val cryptoCurrency: String = "",
    val rate: Double,
    var frequencyUpdate: Int = FREQ_UPDATE,
    val id: Long = UNDEFINED_ID,
)
