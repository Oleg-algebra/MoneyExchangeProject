package com.example.moneyexchwnage.presentation

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG

class CurrencyDiffUtilCallbackAsync
    :DiffUtil.ItemCallback<CoinInfo>(){
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.coinName == newItem.coinName
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}