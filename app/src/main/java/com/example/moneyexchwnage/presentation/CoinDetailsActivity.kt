package com.example.moneyexchwnage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.moneyexchwnage.R
import com.example.moneyexchwnage.domain.CURRENCY_CODE
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.UNDEFINED_COIN
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import kotlinx.coroutines.launch

class CoinDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_details)
        if(savedInstanceState == null){
            parseIntent()
        }

    }

    fun setupFragment(fragment: CoinDetailsFragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.coinDetailsFragment,fragment)
            .commit()
    }
    var coinName: String = UNDEFINED_COIN
    fun parseIntent(){
        Log.d(TAG, "parseIntent: ")
        if (intent.hasExtra(CURRENCY_CODE)){
            coinName = intent.getStringExtra(CURRENCY_CODE) ?: UNDEFINED_COIN
            Log.d(TAG, "parseIntent: $coinName")
            setupFragment(CoinDetailsFragment.newInstanceFragment(coinName))
        }
    }


}