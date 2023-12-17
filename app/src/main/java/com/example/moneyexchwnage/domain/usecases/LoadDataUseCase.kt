package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.Repository

class LoadDataUseCase(
    private val repository: Repository
) {
    operator fun invoke() = repository.loadData()
}