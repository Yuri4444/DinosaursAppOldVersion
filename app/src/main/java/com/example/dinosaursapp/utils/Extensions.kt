package com.example.dinosaursapp.utils

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

fun Context.getCurrentLanguage(): String {
    return if (Locale.getDefault().language == Locale("ru").language) "ru" else "en"
}

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