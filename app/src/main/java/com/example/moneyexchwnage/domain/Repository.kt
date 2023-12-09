package com.example.moneyexchwnage.domain

interface Repository {

    fun addCurrency(currency: Currency)
    fun removeCurrency(currency: Currency)
    fun getCurrencyList(): List<Currency>
    fun getCurrency(id: Long): Currency

}