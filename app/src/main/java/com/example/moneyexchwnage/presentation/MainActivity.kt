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
            Log.d(TAG, "onCreate: currency list: $it")
        }

        showButton.setOnClickListener {
            viewModel.getCurrencyList()
            Log.d(TAG, "showButton click:  ")
        }

        removeButton.setOnClickListener {
            val list = viewModel.liveData.value
            var item: Currency? = null
            if(list != null){
                if(list.isNotEmpty()){
                    item = list[0]
                }
            }
            if(item != null) {
                viewModel.removeCurrency(item)
                Log.d(TAG, "item: $item removed")
            }else{
                Log.d(TAG, "Remove: nothing to remove ")
            }

        }

    }

    companion object{
        val TAG = "XXXX"
    }
}