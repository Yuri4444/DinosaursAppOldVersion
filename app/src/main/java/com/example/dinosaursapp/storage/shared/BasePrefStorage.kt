package com.example.dinosaursapp.storage.shared

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

@SuppressLint("ApplySharedPref")
abstract class BasePrefStorage(context: Context) {

    private val gson by lazy { Gson() }
    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
    }
//
    fun obj(key: String, obj: Any) {
        val json = gson.toJson(obj)
        string(key, json)
    }

    fun <T> obj(key: String, clazz: Class<T>): T? {
        val str = string(key)
        return gson.fromJson<T>(str, clazz)
    }

    fun string(key: String, def: String? = null): String? = prefs.getString(key, def)

    fun string(key: String, value: String) {
        prefs.edit()
                .putString(key, value)
                .commit()
    }

    fun boolean(key: String, def: Boolean): Boolean = prefs.getBoolean(key, def)

    fun boolean(key: String, value: Boolean?) {
        prefs.edit()
                .putBoolean(key, value ?: false)
                .commit()
    }

    fun float(key: String, def: Float = 0f): Float = prefs.getFloat(key, def)

    fun float(key: String, value: Float?) {
        prefs.edit()
                .putFloat(key, value ?: 0f)
                .commit()
    }

    fun int(key: String, def: Int = 0): Int = prefs.getInt(key, def)

    fun int(key: String, value: Int?) {
        prefs.edit()
                .putInt(key, value ?: 0)
                .commit()
    }

    fun long(key: String, def: Long = 0): Long = prefs.getLong(key, def)

    fun long(key: String, value: Long?) {
        prefs.edit()
                .putLong(key, value ?: 0)
                .commit()
    }

    fun remove(key: String) {
        prefs.edit()
                .remove(key)
                .commit()
    }
}