package com.example.dinosaursapp.domain.usecase.air

import com.example.dinosaursapp.data.repository.NetRepository
import javax.inject.Inject

class AirUseCase @Inject constructor(private val netRepository: NetRepository) {

    suspend fun getDinosaursList() = netRepository.getDinosaursList().dinosaurs?.en?.air

}