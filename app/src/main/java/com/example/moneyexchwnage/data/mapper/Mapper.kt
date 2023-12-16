package com.example.moneyexchwnage.data.mapper

import com.example.moneyexchwnage.data.dataBase.CoinEntity
import com.example.moneyexchwnage.data.network.CoinDto
import com.example.moneyexchwnage.domain.CoinInfo
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class Mapper {



    fun mapDataDtoToEntity(coinDto: CoinDto): CoinEntity{
        val details = coinDto.raw?.coinDetailedInfo
        return CoinEntity(
            coinName = details?.fromsymbol?: "null",
            toCurrency = details?.tosymbol ?: "null",
            coinPrice = details?.price ?: -1.0,
            lastUpdate = convertTimestampToTime(details?.lastupdate),
            high24hour = details?.high24hour ?: -1.0,
            low24hour = details?.low24hour ?: -1.0,
            imageUrl = details?.imageurl ?: "null"
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

    fun dataDtosToEntities(dataDtos: List<CoinDto>): List<CoinEntity>{
        return dataDtos.map { mapDataDtoToEntity(it) }
    }
    fun mapEntityToCoinInfo(coinEntity: CoinEntity): CoinInfo{
        return CoinInfo(
            coinName = coinEntity.coinName,
            toCurrency = coinEntity.toCurrency,
            coinPrice = coinEntity.coinPrice,
            lastUpdate = coinEntity.lastUpdate,
            high24hour = coinEntity.high24hour,
            low24hour = coinEntity.low24hour,
            imageUrl = coinEntity.imageUrl
        )
    }

    fun mapCoinInfoToEntity(coinInfo: CoinInfo): CoinEntity{
        return CoinEntity(
            coinName   = coinInfo.coinName,
            toCurrency = coinInfo.toCurrency,
            coinPrice  = coinInfo.coinPrice,
            lastUpdate = coinInfo.lastUpdate,
            high24hour = coinInfo.high24hour,
            low24hour  = coinInfo.low24hour,
            imageUrl   = coinInfo.imageUrl
        )
    }



    fun mapEntitiesToCoinsInfos(entities: List<CoinEntity>): List<CoinInfo>{
        return entities.map { mapEntityToCoinInfo(it) }
    }


    companion object{
        val BASE_IMAGE_URL = "https://www.cryptocompare.com/"
    }
}