package com.example.dinosaursapp.storage.shared

interface SharedMemory {

    fun saveStateMainList(isFull: Boolean?)

    fun getStateMainList() : Boolean

}