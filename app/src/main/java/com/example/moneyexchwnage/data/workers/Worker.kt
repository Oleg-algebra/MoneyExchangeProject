package com.example.moneyexchwnage.data.workers

import android.util.Log
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.data.network.DataDtoObject
import com.example.moneyexchwnage.data.network.RetrofitCoinsInfo
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.presentation.MainActivity
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Worker {
    val baseUrl = "https://min-api.cryptocompare.com/"
    val key = "dd45fcdbbfa53e9a17e9405fc88cb11dd3ccc2c69a772b9fb4ede412249afab1"
    private val retrofitCoinsInfo: RetrofitCoinsInfo = RetrofitCoinsInfo(baseUrl)
    private val mapper = Mapper()
    fun getData():List<CoinInfo>?{
        var dataDtoObject: DataDtoObject? = null
        retrofitCoinsInfo.get(key,object : Callback<DataDtoObject> {
            override fun onResponse(
                call: Call<DataDtoObject>,
                response: Response<DataDtoObject>
            ) {

                dataDtoObject= response.body()
                Log.d(TAG, "onResponse: ${dataDtoObject}")

            }

            override fun onFailure(call: Call<DataDtoObject>, t: Throwable) {
                Log.e(TAG, "Retrofit: $t")

            }
        })
        Log.d(TAG, "onResponse: ${dataDtoObject}")
        val result = dataDtoObject?.data?.map { mapper.mapDataDtoToCoin(it) }
        Log.d(TAG, "getData: $result")
        return result

    }
}