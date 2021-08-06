package com.example.dinosaursapp.ui.screen.land.tab.creta

import androidx.lifecycle.MutableLiveData
import com.example.autoapp.utils.extensions.viewModel.ioToUi
import com.example.dinosaursapp.data.network.model.EnglishVersion
import com.example.dinosaursapp.data.network.model.Land
import com.example.dinosaursapp.data.network.model.RussianVersion
import com.example.dinosaursapp.domain.usecase.land.LandUseCase
import com.example.dinosaursapp.ui.base.AbsViewModel
import javax.inject.Inject

class CretaceousViewModel @Inject constructor(
    private val landUseCase: LandUseCase
) : AbsViewModel() {

    val livedata = MutableLiveData<List<Land>>()

    fun fetchData() {
        ioToUi(
            io = {
                when (landUseCase.getDinosaursList()) {
                    is EnglishVersion -> {
                        (landUseCase.getDinosaursList() as EnglishVersion).land?.filter { it.detail!!.contains("Cretaceous") }
                    }
                    else -> {
                        (landUseCase.getDinosaursList() as RussianVersion).land?.filter { it.detail!!.contains("меловой") }
                    }
                }
            },
            ui = {
                livedata.value = it
            }
        )
    }
}