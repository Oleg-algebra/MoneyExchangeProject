package com.example.moneyexchwnage.data.network

import com.example.moneyexchwnage.data.network.RequestDtoObject
import retrofit2.Call
import retrofit2.http.GET


interface CurrencyService {
    @GET("data/top/totalvolfull?limit=10&tsym=USD")
//    @GET("https://api.npoint.io/309ed9a735bf9cd4a7f9")
    fun getCurrency(): Call<RequestDtoObject>
}