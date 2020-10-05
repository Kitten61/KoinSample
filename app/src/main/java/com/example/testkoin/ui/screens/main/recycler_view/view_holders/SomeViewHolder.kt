package com.example.testkoin.ui.screens.main.recycler_view.view_holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testkoin.models.SomeModel
import kotlinx.android.synthetic.main.text_item.view.*

class SomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var someModel: SomeModel

    fun bind(someModel: SomeModel) {
        this.someModel = someModel
        bindText()
    }

    private fun bindText() {
        with(itemView) {
            tvText.text = someModel.description
        }
    }

}