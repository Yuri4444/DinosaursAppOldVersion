package com.example.dinosaursapp.data.repository.interfeces

import com.example.dinosaursapp.data.network.model.DinosaursList

interface NetRepository {

    suspend fun getDinosaursList() : DinosaursList

}