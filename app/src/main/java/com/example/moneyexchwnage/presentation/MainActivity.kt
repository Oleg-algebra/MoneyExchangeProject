package com.example.moneyexchwnage.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyexchwnage.R
import com.example.moneyexchwnage.domain.CURRENCY_CODE
import com.example.moneyexchwnage.domain.CoinInfo

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CoinAdapter
    private lateinit var constraintLayout: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.liveData.observe(this){
            adapter.submitList(it)
            Log.d(TAG, "mainActivity coins: $it ")
        }

        constraintLayout = findViewById(R.id.constraintMain)
        recyclerView = findViewById(R.id.currency_recycleView)
        adapter = CoinAdapter()
        recyclerView.adapter = adapter
        adapter.clickListener = { view: View, currency: CoinInfo->
            if(constraintLayout.tag.toString() == getString(R.string.portrait)) {
                launchDetailActivity(currency.coinName)
            }else{
                setupFragment(CoinDetailsFragment.newInstanceFragment(currency.coinName))
            }
        }


        adapter.swipeListener = {

            viewModel.removeCoin(it)
        }
        val itemTouchHelper = ItemTouchHelper(adapter.simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

    }

    fun setupFragment(fragment: CoinDetailsFragment){
        supportFragmentManager.popBackStack()
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.coinDetailsFragment,fragment)
            .commit()
    }

    private fun launchDetailActivity(currencyName: String){
        val intent = Intent(this,CoinDetailsActivity::class.java)
        intent.putExtra(CURRENCY_CODE,currencyName)
        startActivity(intent)
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