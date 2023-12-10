package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.TestCurrency
import com.example.moneyexchwnage.domain.Repository

class RemoveCurrency(
    private val repository: Repository
) {
    fun removeCurrency(currency: Currency){
        repository.removeCurrency(currency)
    }
}