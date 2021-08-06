package com.example.dinosaursapp.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.isFirstVisible(): Boolean {
    val layoutManager = this.layoutManager as LinearLayoutManager
    val pos = layoutManager.findFirstCompletelyVisibleItemPosition()
    val numItems: Int = this.adapter!!.itemCount
    return pos >= numItems - numItems
}

fun RecyclerView.isLastVisible(): Boolean {
    val layoutManager = this.layoutManager as LinearLayoutManager
    val pos = layoutManager.findLastCompletelyVisibleItemPosition()
    val numItems: Int = this.adapter!!.itemCount
    return pos >= numItems - 1
}