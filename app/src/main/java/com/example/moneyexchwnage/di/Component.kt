package com.example.moneyexchwnage.di

import com.example.moneyexchwnage.presentation.CoinDetailViewModel
import com.example.moneyexchwnage.presentation.MainViewModel
import dagger.Component

@Component(modules = [DataModule::class,DomainModule::class])
interface Component {
    fun inject(viewModel: MainViewModel)

    fun inject(viewModel: CoinDetailViewModel)


}