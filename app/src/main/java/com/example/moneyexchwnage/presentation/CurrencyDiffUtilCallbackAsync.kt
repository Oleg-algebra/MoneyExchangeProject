package com.example.moneyexchwnage.presentation

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.moneyexchwnage.data.network.CoinName
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG

class CurrencyDiffUtilCallbackAsync
    :DiffUtil.ItemCallback<CoinInfo>(){
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        Log.d(TAG, "areItemsTheSame: ${oldItem.coinName == newItem.coinName}" +
                " old:  ${oldItem.coinName} new: ${newItem.coinName}")
        return oldItem.coinName == newItem.coinName
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
//        Log.d(TAG, "areContentsTheSame: ${oldItem == newItem} ${oldItem.coinName}")
        return oldItem == newItem
    }
}