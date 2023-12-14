package com.example.moneyexchwnage.data.mapper

import android.util.Log
import com.example.moneyexchwnage.data.network.CoinDto
import com.example.moneyexchwnage.data.network.DataDtoObject
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class Mapper {



    fun mapDataDtoToCoin(coinDto: CoinDto): CoinInfo{
        val details = coinDto.raw?.coinDetailedInfo
        return CoinInfo(
            coinName = coinDto.coinName?.fullName?:"",
            toCurrency = details?.tosymbol ?: "",
            coinPrice = details?.price ?: 0.0,
            lastUpdate = convertTimestampToTime(details?.lastupdate),
            high24hour = details?.high24hour ?: 0.0,
            low24hour = details?.low24hour ?: 0.0,
            imageUrl = BASE_IMAGE_URL + (details?.imageurl ?: coinDto.coinName?.imageUrl)
      )
    }
    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    companion object{
        val BASE_IMAGE_URL = "https://www.cryptocompare.com/"
    }
}