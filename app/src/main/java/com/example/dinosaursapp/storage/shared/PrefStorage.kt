package com.example.dinosaursapp.storage.shared

import android.content.Context
import javax.inject.Inject

class PrefStorage @Inject constructor(
    context: Context
) : BasePrefStorage(context), SharedMemory {

    override fun saveStateMainList(isFull: Boolean?) {
        boolean(KEY_STATE_LIST, isFull)
    }

    override fun getStateMainList() = boolean(KEY_STATE_LIST, false)

    companion object {
        private const val KEY_STATE_LIST = "key_state_list"
    }
}