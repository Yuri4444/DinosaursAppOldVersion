package com.example.dinosaursapp.ui.screen.characters.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dinosaursapp.R
import com.example.dinosaursapp.data.network.model.Land
import kotlinx.android.synthetic.main.item_base.view.*
import java.util.*

class BaseAdapter(private val context: Context) :
    RecyclerView.Adapter<BaseAdapter.ViewHolder>() {

    private val list: MutableList<Land> = ArrayList()

    fun setData(newList: List<Land>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_base, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseAdapter.ViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(results: Land) {
            Glide.with(context).load(results.imageMain)
                .into(itemView.ivImage)
            itemView.tvTitle.text = results.title
        }
    }
}