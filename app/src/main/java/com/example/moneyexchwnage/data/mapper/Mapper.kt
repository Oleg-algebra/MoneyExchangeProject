package com.example.moneyexchwnage.data.mapper

import com.example.moneyexchwnage.data.network.CoinDto
import com.example.moneyexchwnage.data.network.DataDtoObject
import com.example.moneyexchwnage.domain.CoinInfo

class Mapper {



    fun mapDataDtoToCoin(coinDto: CoinDto): CoinInfo{
        val details = coinDto.raw?.coinDetailedInfo
        return CoinInfo(
            coinName = coinDto.coinName?.fullName?:"",
            toCurrency = details?.tosymbol ?: "",
            coinPrice = details?.price ?: 0.0,
            lastUpdate = details?.lastupdate ?: 0L,
            high24hour = details?.high24hour ?: 0.0,
            low24hour = details?.low24hour ?: 0.0,
            imageUrl = BASE_IMAGE_URL + (details?.imageurl ?: coinDto.coinName?.imageUrl)
      )
    }

    companion object{
        val BASE_IMAGE_URL = "https://www.cryptocompare.com/"
    }
}