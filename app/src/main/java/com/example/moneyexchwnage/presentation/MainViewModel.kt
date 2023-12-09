package com.example.moneyexchwnage.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moneyexchwnage.data.RepositoryImpl
import com.example.moneyexchwnage.domain.Currency
import com.example.moneyexchwnage.domain.usecases.GetCurrencyList
import com.example.moneyexchwnage.domain.usecases.RemoveCurrency

class MainViewModel: ViewModel() {

    private val repo = RepositoryImpl
    private val getCurrencyListUseCase = GetCurrencyList(repo)
    private val removeCurrencyUseCase = RemoveCurrency(repo)

    val liveData = MutableLiveData<List<Currency>>()

    fun getCurrencyList(){
        val currencyList = getCurrencyListUseCase.getCurrencyList()
        liveData.value = currencyList
    }


}