package com.example.moneyexchwnage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.moneyexchwnage.R
import com.example.moneyexchwnage.data.PairsRepositoryImpl
import com.example.moneyexchwnage.domain.CurrencyPair
import com.example.moneyexchwnage.domain.usecases.GetAllPairs
import com.example.moneyexchwnage.domain.usecases.RemoveCurrencyPair

class MainActivity : AppCompatActivity() {
    private lateinit var showButton: Button
    private lateinit var removeButton: Button
    lateinit var pair: CurrencyPair
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showButton = findViewById(R.id.showButton)
        removeButton = findViewById(R.id.removeButton)

        val repo = PairsRepositoryImpl()
        val getALL = GetAllPairs(repo)
        val removeCase = RemoveCurrencyPair(repo)

        showButton.setOnClickListener {
            Log.d(TAG, "Pairs: ${getALL.getAllPairs()}")
        }

        removeButton.setOnClickListener {
            if(repo.pairs.isNotEmpty()){
                pair = repo.pairs[0]
                removeCase.removePair(pair)
                Log.d(TAG, "Pair removed")
            }else{
                Log.d(TAG, "No pairs. No remove.")
            }

        }

    }

    companion object{
        val TAG = "XXXX"
    }
}