package com.example.moneyexchwnage.di

import android.app.Application
import com.example.moneyexchwnage.data.dataBase.CoinDao
import com.example.moneyexchwnage.data.dataBase.CoinDataBase
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCoinDao(application: Application): CoinDao{
        return CoinDataBase.getDatabase(application).coinDao()
    }

}