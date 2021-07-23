package com.example.dinosaursapp.domain.usecase.aqua

import com.example.dinosaursapp.data.repository.NetRepository
import javax.inject.Inject

class AquaUseCase @Inject constructor(private val netRepository: NetRepository) {

    suspend fun getDinosaursList() = netRepository.getDinosaursList().dinosaurs?.en?.aqua

}