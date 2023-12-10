package com.example.shop.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyexchwnage.R
import com.example.moneyexchwnage.domain.TestCurrency
import com.example.moneyexchwnage.presentation.CurrencyDiffUtilCallbackAsync
import com.example.moneyexchwnage.presentation.MainActivity.Companion.TAG
import androidx.recyclerview.widget.ListAdapter
import com.example.moneyexchwnage.domain.Currency

class CurrencyAdapter
    : ListAdapter<Currency,
        CurrencyAdapter.ShopItemViewHolder>(CurrencyDiffUtilCallbackAsync()){

//    var currencyList = listOf<Currency>()
//        set(value) {
//            field = value
////            notifyDataSetChanged()  // FIXME:
//        }

    class ShopItemViewHolder(view: View):
        RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.currencyName)
        val rate: TextView = view.findViewById(R.id.rate)
        val cardView: CardView = view.findViewById(R.id.currency_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d(TAG, "onCreateViewHolder: ")
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.currency_layout, parent, false)

        return ShopItemViewHolder(view)
    }



    var clickListener: ((view: View, item: Currency)->Unit  )? = null
    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
        val currency = getItem(position)
        with(holder){
            name.text = "${currency.cryptoCurrency}"
            rate.text = currency.rate.toString()

            cardView.setOnClickListener {
                clickListener?.invoke(cardView, currency)
            }

        }
    }

    var swipeListener: ((item: Currency) -> Unit)? = null
    var simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
        ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
//                    or ItemTouchHelper.DOWN or ItemTouchHelper.UP
        ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
            val position = viewHolder.adapterPosition
            val shopItem = getItem(position)
            swipeListener?.invoke(shopItem)
        }
    }
    

}