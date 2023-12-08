package com.example.moneyexchwnage.data

import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.CurrencyPair
import com.example.moneyexchwnage.domain.PairsRepository

class PairsRepositoryImpl: PairsRepository {
    private var currencyID = 0L
    private var pairID = 0L
    val pairs = mutableListOf<CurrencyPair>()
    private val currenciesList = mutableListOf<Currency>()

    init {
        currenciesList.add(Currency(
            ++currencyID,
            "USD",
            true,
        ))
        currenciesList.add(
            Currency(
                ++currencyID,
                "EUR",
            )
        )
        currenciesList.add(
            Currency(
                ++currencyID,
                "UAH",
            )
        )
        for (i in 0..<currenciesList.size){
            for(j in i+1..<currenciesList.size){
                val cur1 = currenciesList[i]
                val cur2 = currenciesList[j]
                pairs.add(
                    CurrencyPair(
                        cur1.id,
                        cur2.id,
                        1.0,
                        id = ++pairID,
                    )
                )
            }
        }
    }

    override fun addCurrencyPair(pair: CurrencyPair) {
        pairs.add(pair)
    }

    override fun removeCurrencyPair(pair: CurrencyPair) {
        pairs.remove(pair)
    }

    override fun getAllPairs(): List<CurrencyPair> {
        return pairs
    }
}