package com.example.moneyexchwnage.data

import com.example.moneyexchwnage.domain.TestCurrency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface CurrencyService {  //FIXME:  need to fix
    @GET("data/price?fsym=ETH&tsyms=BTC,USD,EUR")
    fun getCurrency()
    : Call<TestCurrency>
}