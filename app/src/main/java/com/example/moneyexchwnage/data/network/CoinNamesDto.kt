package com.example.moneyexchwnage.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNamesDto(

    @SerializedName("Data")
    @Expose
    var data: List<CoinDtoObject>? = null,

)
