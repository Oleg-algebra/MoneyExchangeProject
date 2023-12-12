package com.example.moneyexchwnage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyexchwnage.data.network.DataDtoObject
import com.example.moneyexchwnage.data.network.RetrofitCoinsInfo
import com.example.moneyexchwnage.R
import com.example.shop.presentation.CurrencyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CurrencyAdapter

    private lateinit var textView: TextView

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.liveData.observe(this){
//            adapter.submitList(it)
            Log.d(TAG, "$it ")
        }
        
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        button.setOnClickListener {
            Log.d(TAG, "onCreate: ${viewModel.getCurrencyList()}")
        }



//        recyclerView = findViewById(R.id.currency_recycleView)
//        adapter = CurrencyAdapter()
//        recyclerView.adapter = adapter
//        adapter.clickListener = { view: View, currency: Currency->
//            Toast.makeText(this@MainActivity, currency.toString(), Toast.LENGTH_SHORT).show()
//        }
//
//

//
//
//        adapter.swipeListener = {
//            viewModel.removeCurrency(it)
//        }
//        val itemTouchHelper = ItemTouchHelper(adapter.simpleItemTouchCallback)
//        itemTouchHelper.attachToRecyclerView(recyclerView)

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