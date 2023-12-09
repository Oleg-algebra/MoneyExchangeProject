package com.example.moneyexchwnage.domain

import androidx.lifecycle.LiveData

interface Repository {

    fun addCurrency(currency: Currency)
    fun removeCurrency(currency: Currency)
    fun getCurrencyList(): LiveData<List<Currency>>
    fun getCurrency(id: Long): Currency

}