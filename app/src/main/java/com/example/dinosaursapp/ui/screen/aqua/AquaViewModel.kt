package com.example.dinosaursapp.ui.screen.aqua

import androidx.lifecycle.MutableLiveData
import com.example.autoapp.utils.extensions.viewModel.ioToUi
import com.example.dinosaursapp.data.network.model.Aqua
import com.example.dinosaursapp.domain.usecase.aqua.AquaUseCase
import com.example.dinosaursapp.ui.base.AbsViewModel
import javax.inject.Inject

class AquaViewModel @Inject constructor(
    private val netRepository: AquaUseCase
) : AbsViewModel() {

    val liveData = MutableLiveData<List<Aqua>>()

    fun fetch() {
        ioToUi(
            io = {
                netRepository.getDinosaursList()
            },
            ui = {
                liveData.value = it
            }
        )
    }

}