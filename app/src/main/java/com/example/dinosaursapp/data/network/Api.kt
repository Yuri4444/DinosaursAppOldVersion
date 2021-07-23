package com.example.dinosaursapp.data.network

import com.example.dinosaursapp.data.network.model.DinosaursList
import retrofit2.http.GET

interface Api {

    @GET("v3/43bcb396-6182-417d-a2eb-62dcb8a73e3e")
    suspend fun getDinosaursList() : DinosaursList
}