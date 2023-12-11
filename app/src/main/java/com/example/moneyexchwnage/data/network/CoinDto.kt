package com.example.moneyexchwnage.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinDto(
    @SerializedName("CoinInfo")
    @Expose
    var coinName: CoinName? = null,

    @SerializedName("RAW")
    @Expose
    var raw: Raw? = null,
//    @SerializedName("USD")
//    @Expose
//    var coinDetailedInfo: CoinDetailedInfo? = null

    )