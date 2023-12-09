package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.Repository

class GetCurrency(
    private val repository: Repository
) {
    fun getCurrency(id: Long): Currency =  repository.getCurrency(id)
}