package com.example.moneyexchwnage.domain

data class Currency(
    val cryptoCurrency: String = "",
    val rate: Double,
    val id: Long = UNDEFINED_ID,
)
