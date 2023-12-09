package com.example.moneyexchwnage.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.Repository

object RepositoryImpl: Repository {
    private var currencyID = 0L
    val currenciesList = mutableListOf<Currency>()
    val liveData = MutableLiveData<List<Currency>>()

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
        update()
    }

    override fun removeCurrency(currency: Currency) {
        currenciesList.remove(currency)
        update()
    }

    override fun getCurrencyList(): LiveData<List<Currency>> {
        return liveData.apply {
            update()
        }
    }

    override fun getCurrency(id: Long): Currency {
        return currenciesList.find { it.id == id } ?:
        throw RuntimeException("Currency with id $id not found")
    }

    fun update(){
        liveData.value = currenciesList.toList()
    }
}