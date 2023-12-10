package com.example.activitieslifecycle

import android.util.Log
import com.example.moneyexchwnage.data.CurrencyService
import com.example.moneyexchwnage.domain.TestCurrency
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCurrency(baseUrl: String) {   //FIXME:  need to fix


    private val retrofit: Retrofit
    private val service: CurrencyService

    init {
        Log.d(TAG, "RetrofitCurrency: init")
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(CurrencyService::class.java)

    }

    fun get(key: String, callback: Callback<TestCurrency>) {
        Log.d(TAG, "RetrofitCurrency get: get data")
        val call: Call<TestCurrency> = service.getCurrency()
        Log.d(TAG, "call: $call")
        call.enqueue(callback)
    }

}