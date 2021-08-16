package com.example.dinosaursapp.domain.usecase.air

import android.content.Context
import com.example.dinosaursapp.data.network.model.localizedCurrentLang
import com.example.dinosaursapp.data.repository.NetRepository
import javax.inject.Inject

class AirUseCase @Inject constructor(
    private val context: Context,
    private val netRepository: NetRepository
) {

    suspend fun getDinosaursList() =
        netRepository.getDinosaursList().dinosaurs?.localizedCurrentLang(context)

}