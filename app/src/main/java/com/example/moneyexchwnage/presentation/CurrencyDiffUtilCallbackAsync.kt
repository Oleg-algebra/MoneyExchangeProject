package com.example.moneyexchwnage.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.moneyexchwnage.domain.Currency

class CurrencyDiffUtilCallbackAsync
    :DiffUtil.ItemCallback<Currency>(){
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem == newItem
    }
}