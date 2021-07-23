package com.example.dinosaursapp.data.repository.impl

import com.example.dinosaursapp.data.network.Api
import com.example.dinosaursapp.data.network.model.DinosaursList
import com.example.dinosaursapp.data.repository.interfeces.NetRepository

class NetRepositoryImpl(private val api: Api) : NetRepository {

    override suspend fun getDinosaursList() = api.getDinosaursList()

}