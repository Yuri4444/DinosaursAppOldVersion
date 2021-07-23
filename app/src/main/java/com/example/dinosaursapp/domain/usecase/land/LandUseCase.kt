package com.example.dinosaursapp.domain.usecase.land

import com.example.dinosaursapp.data.repository.NetRepository
import javax.inject.Inject

class LandUseCase @Inject constructor(private val netRepository: NetRepository) {

    suspend fun getDinosaursList() = netRepository.getDinosaursList().dinosaurs?.en?.land

}