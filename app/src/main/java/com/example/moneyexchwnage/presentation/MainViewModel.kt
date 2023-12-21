package com.example.moneyexchwnage.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.moneyexchwnage.di.DaggerComponent
import com.example.moneyexchwnage.di.DomainModule
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.usecases.GetCoinListUseCase
import com.example.moneyexchwnage.domain.usecases.LoadDataUseCase
import com.example.moneyexchwnage.domain.usecases.RemoveCoinUseCase
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel(application: Application): AndroidViewModel(application) {

    @Inject lateinit var getCoinListUseCase : GetCoinListUseCase
    @Inject lateinit var loadDataUseCase : LoadDataUseCase
    @Inject lateinit var removeCoinUseCase : RemoveCoinUseCase


    val liveData: LiveData<List<CoinInfo>>
            get() = getCoinListUseCase.getCurrencyList()



    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, "onCleared: ViewModel deleted", )
    }
    fun loadData(){
        loadDataUseCase()
    }

    fun removeCoin(coinInfo: CoinInfo){
        viewModelScope.launch { removeCoinUseCase.removeCoin(coinInfo) }

    }
    init {
        DaggerComponent
            .builder()
            .domainModule(DomainModule(application))
//            .dataModule(DataModule(application))
            .build()
            .inject(this)
        loadData()
    }
}