package com.example.moneyexchwnage.data.network

import android.util.Log
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCurrency(baseUrl: String) {


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

    fun get(key: String, callback: Callback<RequestDtoObject>) {
        Log.d(TAG, "RetrofitCurrency get: get data")
        val call: Call<RequestDtoObject> = service.getCurrency()
        Log.d(TAG, "call: $call")
        call.enqueue(callback)
    }

}