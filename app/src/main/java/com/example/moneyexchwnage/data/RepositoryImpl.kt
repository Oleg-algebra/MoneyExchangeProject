package com.example.moneyexchwnage.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.data.network.DataDtoObject
import com.example.moneyexchwnage.data.network.RetrofitCoinsInfo
import com.example.moneyexchwnage.data.workers.Worker
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.Repository
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import kotlinx.coroutines.delay

object RepositoryImpl: Repository {
    private var currencyID = 0L
    val currenciesList = mutableListOf<CoinInfo>()
    val liveData = MutableLiveData<List<CoinInfo>>()



    init {

    }

    override fun getCurrencyList(): LiveData<List<CoinInfo>> {
        return liveData.apply {
            update()
        }
    }

    override fun getCurrency(id: Long): CoinInfo {
        return CoinInfo()           //FIXME: fix needed
//        return currenciesList.find { it.id == id } ?:
//        throw RuntimeException("Currency with id $id not found")
    }

    override fun loadData(){
        liveData.value = Worker.getData()
        Log.d(TAG, "loadData: finished")
    }

    fun update(){
        liveData.value = currenciesList.toList()
    }


}