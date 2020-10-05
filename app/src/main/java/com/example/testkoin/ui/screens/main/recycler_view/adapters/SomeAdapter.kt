package com.example.testkoin.ui.screens.main.recycler_view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testkoin.R
import com.example.testkoin.models.SomeModel
import com.example.testkoin.ui.screens.main.recycler_view.view_holders.SomeViewHolder

class SomeAdapter : RecyclerView.Adapter<SomeViewHolder>() {

    private val items: ArrayList<SomeModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SomeViewHolder {
        return SomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SomeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addItems(items: List<SomeModel>) {
        with(this.items) {
            addAll(items)
            notifyItemRangeInserted(this.size - items.size, items.size)
        }
    }

}