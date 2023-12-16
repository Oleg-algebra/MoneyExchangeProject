package com.example.moneyexchwnage.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface CoinDao {
    @Query("SELECT * FROM top10_coins")
    fun getListEntities(): LiveData<List<CoinEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCoinEntity(coinEntity: CoinEntity)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateCoinEntity(coinEntity: CoinEntity)

    @Query("DELETE FROM top10_coins")
    suspend fun clearTable()


}