package com.example.moneyexchwnage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyexchwnage.data.network.RequestDtoObject
import com.example.moneyexchwnage.data.network.RetrofitCurrency
import com.example.moneyexchwnage.R
import com.example.shop.presentation.CurrencyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CurrencyAdapter

    private var retrofitCurrency: RetrofitCurrency? = null
    private lateinit var textView: TextView

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: ")
        
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        val key = "dd45fcdbbfa53e9a17e9405fc88cb11dd3ccc2c69a772b9fb4ede412249afab1"
        button.setOnClickListener {
            Log.d(TAG, "button pressed ")
            retrofitCurrency?.get(key, object : Callback<RequestDtoObject>{
                override fun onResponse(
                    call: Call<RequestDtoObject>,
                    response: Response<RequestDtoObject>
                ) {
                    Log.d(TAG, "onResponse: OK")
                    val body = response.body()
                    Log.d(TAG, "response: $response")
//                    textView.text = body.toString()
                    Log.d(TAG, "result: ${body?.data?.get(0)?.raw?.coinDetailedInfo?.fromsymbol} ")
                }

                override fun onFailure(call: Call<RequestDtoObject>, t: Throwable) {
                    Log.e(TAG, "Retrofit: $t")

                }

            })


        }

//        recyclerView = findViewById(R.id.currency_recycleView)
//        adapter = CurrencyAdapter()
//        recyclerView.adapter = adapter
//        adapter.clickListener = { view: View, currency: Currency->
//            Toast.makeText(this@MainActivity, currency.toString(), Toast.LENGTH_SHORT).show()
//        }
//
//
//        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        viewModel.liveData.observe(this){
//            adapter.submitList(it)
//            Log.d(TAG, "$it ")
//        }
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
        Log.d(TAG, "onStart: create retrofit")
        val baseUrl = "https://min-api.cryptocompare.com/"
        retrofitCurrency = RetrofitCurrency(baseUrl)


    }

    override fun onStop() {
        super.onStop()
        retrofitCurrency = null

    }
    

    companion object{
        val TAG = "XXXX"
    }
}