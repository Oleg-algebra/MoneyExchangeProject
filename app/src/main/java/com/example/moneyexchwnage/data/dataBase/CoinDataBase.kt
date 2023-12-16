package com.example.moneyexchwnage.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(CoinEntity::class), version = 1, exportSchema = false)
public abstract class CoinDataBase : RoomDatabase() {

    abstract fun coinDao(): CoinDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CoinDataBase? = null

        fun getDatabase(context: Context): CoinDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        CoinDataBase::class.java,
                        "word_database"
                    ).build()
                    INSTANCE = instance

                    // return instance
                    instance
                }
            }
        }
    }
}