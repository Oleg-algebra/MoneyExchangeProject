package com.example.moneyexchwnage.data

import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.Repository

object RepositoryImpl: Repository {
    private var currencyID = 0L
    val currenciesList = mutableListOf<Currency>()

    init {
        currenciesList.add(Currency(
            "USD",
            1.0,
            id = ++currencyID
        ))
        currenciesList.add(
            Currency(

                "EUR",
                1.0,
                id = ++currencyID
            )
        )
        currenciesList.add(
            Currency(
                "UAH",
                1.0,
                id = ++currencyID
            )
        )

    }

    override fun addCurrency(currency: Currency) {
        currenciesList.add(currency)
    }

    override fun removeCurrency(currency: Currency) {
        currenciesList.remove(currency)
    }

    override fun getCurrencyList(): List<Currency> {
        return currenciesList.toList()
    }

    override fun getCurrency(id: Long): Currency {
        return currenciesList.find { it.id == id } ?:
        throw RuntimeException("Currency with id $id not found")
    }
}