package com.example.moneyexchwnage.domain.usecases

import com.example.moneyexchwnage.domain.Repository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() = repository.loadData()
}