package com.example.dinosaursapp.ui.screen.land

import androidx.lifecycle.MutableLiveData
import com.example.autoapp.utils.extensions.viewModel.ioToUi
import com.example.dinosaursapp.data.network.model.Land
import com.example.dinosaursapp.domain.usecase.land.LandUseCase
import com.example.dinosaursapp.ui.base.AbsViewModel
import javax.inject.Inject

class LandViewModel @Inject constructor(
    private val netRepository: LandUseCase
) : AbsViewModel() {

    val liveData = MutableLiveData<List<Land>>()

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
