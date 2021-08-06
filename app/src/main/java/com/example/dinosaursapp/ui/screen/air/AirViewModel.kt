package com.example.dinosaursapp.ui.screen.air

import androidx.lifecycle.MutableLiveData
import com.example.autoapp.utils.extensions.viewModel.ioToUi
import com.example.dinosaursapp.data.network.model.Air
import com.example.dinosaursapp.data.network.model.EnglishVersion
import com.example.dinosaursapp.data.network.model.RussianVersion
import com.example.dinosaursapp.domain.usecase.air.AirUseCase
import com.example.dinosaursapp.ui.base.AbsViewModel
import javax.inject.Inject

class AirViewModel @Inject constructor(
    private val netRepository: AirUseCase
) : AbsViewModel() {

    val liveData = MutableLiveData<List<Air>>()

    fun fetch() {
        ioToUi(
            io = {
                when (netRepository.getDinosaursList()) {
                    is EnglishVersion -> {
                        (netRepository.getDinosaursList() as EnglishVersion).air
                    }
                    else -> {
                        (netRepository.getDinosaursList() as RussianVersion).air
                    }
                }
            },
            ui = {
                liveData.value = it
            }
        )
    }

}