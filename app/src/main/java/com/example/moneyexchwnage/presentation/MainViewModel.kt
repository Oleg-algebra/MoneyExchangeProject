package com.example.moneyexchwnage.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneyexchwnage.data.RepositoryImpl
import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.domain.usecases.GetCurrencyList
import com.example.moneyexchwnage.domain.usecases.RemoveCurrency

class MainViewModel: ViewModel() {

    private val repo = RepositoryImpl
    private val getCurrencyListUseCase = GetCurrencyList(repo)
    private val removeCurrencyUseCase = RemoveCurrency(repo)

    val liveData: LiveData<List<CoinName>>
            get() = getCurrencyListUseCase.getCurrencyList()

    fun getCurrencyList(){
        getCurrencyListUseCase.getCurrencyList()
    }

    fun removeCurrency(coinName: CoinName){
        removeCurrencyUseCase.removeCurrency(coinName)
    }


}