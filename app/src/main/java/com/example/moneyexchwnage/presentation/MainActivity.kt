package com.example.moneyexchwnage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.moneyexchwnage.R
import com.example.moneyexchwnage.domain.Currency

class MainActivity : AppCompatActivity() {
    private lateinit var showButton: Button
    private lateinit var removeButton: Button
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showButton = findViewById(R.id.showButton)
        removeButton = findViewById(R.id.removeButton)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.liveData.observe(this){
            Log.d(TAG, "onCreate: curency list: $it")
        }

        showButton.setOnClickListener {
            viewModel.getCurrencyList()
            Log.d(TAG, "showButton click:  ")
        }

        removeButton.setOnClickListener {


        }

    }

    companion object{
        val TAG = "XXXX"
    }
}