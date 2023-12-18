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

    private lateinit var coinNameTextView: TextView
    private lateinit var coinPriceTextView: TextView
    private lateinit var min24Hour: TextView
    private lateinit var max24Hour: TextView
    private lateinit var updateTime: TextView

    private lateinit var viewModel: CoinDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_details)

        coinNameTextView = findViewById(R.id.coinNameDetailed)
        coinPriceTextView = findViewById(R.id.coinPriceDetailed)
        min24Hour = findViewById(R.id.min24H)
        max24Hour = findViewById(R.id.max24H)
        updateTime = findViewById(R.id.lastUpdateDetailed)

        viewModel = ViewModelProvider(this)[CoinDetailViewModel::class.java]
        parseIntent()

        viewModel.getCoin(coinName)

        viewModel.liveData.observe(this){ coinInfo: CoinInfo ->
            Log.d(TAG, "live data detailed activity: $coinInfo")
            "${coinInfo.coinName}/${coinInfo.toCurrency}".let {
                string: String -> coinNameTextView.text = string
            }
            "Coin price: ${coinInfo.coinPrice}".let { coinPriceTextView.text = it }
            "min 24 hours: ${coinInfo.low24hour}".let { min24Hour.text = it }
            "max 24 hours: ${coinInfo.high24hour}".let { max24Hour.text = it }
            "Last update: ${coinInfo.lastUpdate}".let { updateTime.text = it}
        }

    }
    var coinName: String = UNDEFINED_COIN
    fun parseIntent(){
        Log.d(TAG, "parseIntent: ")
        if (intent.hasExtra(CURRENCY_CODE)){
            coinName = intent.getStringExtra(CURRENCY_CODE) ?: UNDEFINED_COIN
            Log.d(TAG, "parseIntent: $coinName")
        }
    }


}