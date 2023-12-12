package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.data.network.DataDtoObject
import com.example.moneyexchwnage.domain.Repository

class LoadDataUseCase(
    private val repository: Repository
) {
    fun loadData(){
        repository.loadData()
    }
}