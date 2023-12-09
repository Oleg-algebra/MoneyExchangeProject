package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.Repository

class AddCurrency(
    private val repository: Repository
) {
    fun addCurrency(currency: Currency){
        repository.addCurrency(currency)
    }
}