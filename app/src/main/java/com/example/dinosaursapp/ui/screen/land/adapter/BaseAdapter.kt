package com.example.dinosaursapp.ui.screen.land.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dinosaursapp.R
import com.example.dinosaursapp.data.network.model.DinosaurType
import com.example.dinosaursapp.data.network.model.Air
import com.example.dinosaursapp.data.network.model.Land
import com.example.dinosaursapp.data.network.model.Aqua
import kotlinx.android.synthetic.main.item_base.view.*
import java.lang.RuntimeException
import java.util.*

class BaseAdapter(private val context: Context) :
    RecyclerView.Adapter<BaseAdapter.ViewHolder>() {

    private val list: MutableList<DinosaurType> = ArrayList()

    fun setData(newList: List<DinosaurType>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) =
        when (list[position]) {
            is Land -> LAND
            is Aqua -> AQUA
            is Air -> AIR
            else -> AIR
        }

    abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: DinosaurType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =

        when (viewType) {
            LAND -> LandViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_base, parent, false)
            )
            AQUA -> AquaViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_base, parent, false)
            )
            AIR -> AirViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_base, parent, false)
            )
            else -> AirViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_base, parent, false)
            )
        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size

    inner class LandViewHolder(itemView: View) : ViewHolder(itemView) {

        override fun bind(item: DinosaurType) {
            val type = item as Land

            Glide.with(context).load(type.imageMain)
                .into(itemView.ivImage)
            itemView.tvTitle.text = type.title
        }
    }

    inner class AquaViewHolder(itemView: View) : ViewHolder(itemView) {

        override fun bind(item: DinosaurType) {
            val type = item as Aqua

            Glide.with(context).load(type.image)
                .into(itemView.ivImage)
            itemView.tvTitle.text = type.title
        }
    }

    inner class AirViewHolder(itemView: View) : ViewHolder(itemView) {

        override fun bind(item: DinosaurType) {
            val type = item as Air

            Glide.with(context).load(type.image)
                .into(itemView.ivImage)
            itemView.tvTitle.text = type.title
        }
    }

    companion object {
        const val LAND = 0
        const val AQUA = 1
        const val AIR = 2
    }
}