package com.example.moneyexchwnage.domain

data class Currency(
    var id: Long = UNDEFINED_ID,
    val code: String = "",
    var isBaseCurrency: Boolean = false,
)
