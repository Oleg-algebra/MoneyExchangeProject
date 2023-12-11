package com.example.moneyexchwnage.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Raw (
    @SerializedName("USD")
    @Expose
    var coinDetailedInfo: CoinDetailedInfo? = null
)