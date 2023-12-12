package com.example.moneyexchwnage.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataDtoObject(
//    @SerializedName("Message")
//    @Expose
//    var message: String? = null,
//
//    @SerializedName("Type")
//    @Expose
//    var type: Int? = null,

    @SerializedName("Data")
    @Expose
    var data: List<CoinDto>? = null,

//
//    @SerializedName("HasWarning")
//    @Expose
//    var hasWarning: Boolean? = null,
)
