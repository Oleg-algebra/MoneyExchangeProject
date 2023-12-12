package com.example.moneyexchwnage.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneyexchwnage.data.RepositoryImpl
import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.usecases.GetCoinListUseCase
import com.example.moneyexchwnage.domain.usecases.LoadDataUseCase
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG

class MainViewModel: ViewModel() {

    private val repo = RepositoryImpl
    private val getCoinListUseCase = GetCoinListUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)

    val liveData: LiveData<List<CoinInfo>>
            get() = getCoinListUseCase.getCurrencyList()

    fun getCurrencyList(){
        getCoinListUseCase.getCurrencyList()
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, "onCleared: ViewModel deleted", )
    }
    init {
        loadDataUseCase.loadData()
    }
}