package com.example.dinosaursapp.data.repository

import com.example.dinosaursapp.data.network.Api
import javax.inject.Inject

class NetRepository @Inject constructor(private val api: Api) {

    suspend fun getDinosaursList() = api.getDinosaursList()

}