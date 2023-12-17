package com.example.moneyexchwnage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyexchwnage.R
import com.example.moneyexchwnage.domain.CoinInfo

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CoinAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.liveData.observe(this){
            adapter.submitList(it)
//            Log.d(TAG, "mainActivity coins: $it ")
        }


        recyclerView = findViewById(R.id.currency_recycleView)
        adapter = CoinAdapter()
        recyclerView.adapter = adapter
        adapter.clickListener = { view: View, currency: CoinInfo->
            Toast.makeText(this@MainActivity, currency.toString(), Toast.LENGTH_SHORT).show()
        }


        adapter.swipeListener = {

            viewModel.removeCoin(it)
        }
        val itemTouchHelper = ItemTouchHelper(adapter.simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()

    }
    

    companion object{
        val TAG = "XXXX"
    }
}