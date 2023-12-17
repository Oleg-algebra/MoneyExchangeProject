package com.example.moneyexchwnage.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinDtoObject(
    @SerializedName("CoinInfo")
    @Expose
    var coinName: CoinName? = null,
    )