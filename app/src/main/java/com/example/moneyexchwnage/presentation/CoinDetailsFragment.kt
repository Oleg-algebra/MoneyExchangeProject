package com.example.moneyexchwnage.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.moneyexchwnage.R
import com.example.moneyexchwnage.domain.CURRENCY_CODE
import com.example.moneyexchwnage.domain.CoinInfo
import com.example.moneyexchwnage.domain.UNDEFINED_COIN


class CoinDetailsFragment : Fragment() {
    private lateinit var coinNameTextView: TextView
    private lateinit var coinPriceTextView: TextView
    private lateinit var min24Hour: TextView
    private lateinit var max24Hour: TextView
    private lateinit var updateTime: TextView

    private lateinit var viewModel: CoinDetailViewModel
    var coinName: String = UNDEFINED_COIN

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coin_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinNameTextView = view.findViewById(R.id.coinNameDetailed)
        coinPriceTextView = view.findViewById(R.id.coinPriceDetailed)
        min24Hour = view.findViewById(R.id.min24H)
        max24Hour = view.findViewById(R.id.max24H)
        updateTime = view.findViewById(R.id.lastUpdateDetailed)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate: ", )
        with(requireArguments()){
            if(containsKey(CURRENCY_CODE)){
                coinName = getString(CURRENCY_CODE) ?: UNDEFINED_COIN
            }
        }

        viewModel = ViewModelProvider(this)[CoinDetailViewModel::class.java]

        viewModel.getCoin(coinName)

        viewModel.liveData.observe(this){ coinInfo: CoinInfo ->
            Log.d(MainActivity.TAG, "live data detailed activity: $coinInfo")
            "${coinInfo.coinName}/${coinInfo.toCurrency}".let {
                    string: String -> coinNameTextView.text = string
            }
            "Coin price: ${coinInfo.coinPrice}".let { coinPriceTextView.text = it }
            "min 24 hours: ${coinInfo.low24hour}".let { min24Hour.text = it }
            "max 24 hours: ${coinInfo.high24hour}".let { max24Hour.text = it }
            "Last update: ${coinInfo.lastUpdate}".let { updateTime.text = it}
        }

    }

    companion object {
        const val TAG = "RRRRRR"
        fun newInstanceFragment(coinName: String) = CoinDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(CURRENCY_CODE,coinName)
            }
        }


    }


}