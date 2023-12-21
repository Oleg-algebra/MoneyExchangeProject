package com.example.moneyexchwnage.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.moneyexchwnage.di.DaggerComponent
import com.example.moneyexchwnage.di.DomainModule
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.usecases.GetCoinUseCase
import com.example.moneyexchwnage.domain.usecases.LoadDataUseCase
import javax.inject.Inject

class CoinDetailViewModel(application: Application)
    : AndroidViewModel(application) {

    @Inject lateinit var getCoinUseCase : GetCoinUseCase
    @Inject lateinit var loadDataUseCase : LoadDataUseCase

    private lateinit var _liveData: LiveData<CoinInfo>
    val liveData: LiveData<CoinInfo>
        get() = _liveData
    init {
        DaggerComponent
            .builder()
            .domainModule(DomainModule(application))
//            .dataModule(DataModule(application))
            .build()
            .inject(this)

        loadDataUseCase()
    }
    fun getCoin(coinName: String){
        _liveData = getCoinUseCase.getCurrency(coinName)
    }

}