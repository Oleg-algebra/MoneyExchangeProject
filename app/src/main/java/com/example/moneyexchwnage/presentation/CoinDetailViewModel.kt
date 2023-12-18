package com.example.moneyexchwnage.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moneyexchwnage.data.RepositoryImpl
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.usecases.GetCoinUseCase
import com.example.moneyexchwnage.domain.usecases.LoadDataUseCase
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import kotlinx.coroutines.launch

class CoinDetailViewModel(application: Application)
    : AndroidViewModel(application) {

    private val repo = RepositoryImpl(application)
    private val getCoinUseCase = GetCoinUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)

    private lateinit var _liveData: LiveData<CoinInfo>
    val liveData: LiveData<CoinInfo>
        get() = _liveData
    init {
        loadDataUseCase()
    }
    fun getCoin(coinName: String){
        _liveData = getCoinUseCase.getCurrency(coinName)
    }

}