package com.example.moneyexchwnage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyexchwnage.R
import com.example.moneyexchwnage.domain.Currency
import com.example.shop.presentation.CurrencyAdapter
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CurrencyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView = findViewById(R.id.currency_recycleView)
        adapter = CurrencyAdapter()
        recyclerView.adapter = adapter
        adapter.clickListener = { view: View, currency: Currency->
            Toast.makeText(this@MainActivity, currency.toString(), Toast.LENGTH_SHORT).show()
        }


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.liveData.observe(this){
            adapter.submitList(it)
            Log.d(TAG, "$it ")
        }


        adapter.swipeListener = {
            viewModel.removeCurrency(it)
        }
        val itemTouchHelper = ItemTouchHelper(adapter.simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

    }

    companion object{
        val TAG = "XXXX"
    }
}