package com.example.moneyexchwnage.data.network

import android.util.Log
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCoinsInfo(baseUrl: String) {


    private val retrofit: Retrofit
    private val service: ApiService

    init {
        Log.d(TAG, "RetrofitCurrency: init")
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)

    }

    fun get(key: String, callback: Callback<DataDtoObject>) {
        val call: Call<DataDtoObject> = service.getCurrency(apiKey = key)
        call.enqueue(callback)
    }

}