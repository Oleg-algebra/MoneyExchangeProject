package com.example.moneyexchwnage.domain

data class CoinInfo(
    val coinName: String = "",
    val toCurrency: String = "",
    val coinPrice: Double = 0.0,
    val lastUpdate: Long = 0L,
    val high24hour: Double = 0.0,
    val low24hour: Double = 0.0,
    val imageUrl: String = "",
)
