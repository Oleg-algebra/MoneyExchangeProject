package com.example.moneyexchwnage.domain

data class Currency(
    val cryptoCurrency: String = "",
    val rate: Double = -1.0,
    val id: Long = UNDEFINED_ID,
)
