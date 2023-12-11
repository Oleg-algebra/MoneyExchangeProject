package com.example.moneyexchwnage.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.data.network.RequestDtoObject
import com.example.moneyexchwnage.data.network.RetrofitCurrency
import com.example.moneyexchwnage.domain.Repository

object RepositoryImpl: Repository {
    private var currencyID = 0L
    val currenciesList = mutableListOf<CoinName>()
    val liveData = MutableLiveData<List<CoinName>>()


    init {

    }

    override fun getCurrencyList(): LiveData<List<CoinName>> {
        return liveData.apply {
            update()
        }
    }

    override fun getCurrency(id: Long): CoinName {
        return CoinName()           //FIXME: fix needed
//        return currenciesList.find { it.id == id } ?:
//        throw RuntimeException("Currency with id $id not found")
    }

    override fun loadData(){
        //Todo: implement
    }

    fun update(){
        liveData.value = currenciesList.toList()
    }
}