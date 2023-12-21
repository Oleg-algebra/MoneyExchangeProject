package com.example.moneyexchwnage.di

import android.app.Application
import com.example.moneyexchwnage.data.RepositoryImpl
import com.example.moneyexchwnage.data.dataBase.CoinDao
import com.example.moneyexchwnage.data.mapper.Mapper
import com.example.moneyexchwnage.domain.Repository
import dagger.Module
import dagger.Provides

@Module
class DomainModule(private val application: Application) {

    @Provides
    fun provideApplication():Application{
        return application
    }
    @Provides
    fun provideRepositoryImpl(application: Application,
                              mapper: Mapper,
                              dao: CoinDao): Repository {
        return RepositoryImpl(application,
            mapper, dao)
    }
}