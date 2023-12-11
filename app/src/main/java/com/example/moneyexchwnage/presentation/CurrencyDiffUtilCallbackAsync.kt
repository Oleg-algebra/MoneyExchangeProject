package com.example.moneyexchwnage.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.moneyexchwnage.data.network.CoinName

class CurrencyDiffUtilCallbackAsync
    :DiffUtil.ItemCallback<CoinName>(){
    override fun areItemsTheSame(oldItem: CoinName, newItem: CoinName): Boolean {
        return true  //Fixme
    }

    override fun areContentsTheSame(oldItem: CoinName, newItem: CoinName): Boolean {
        return oldItem == newItem
    }
}