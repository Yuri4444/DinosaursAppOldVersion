package com.example.dinosaursapp.ui.screen.land.tab.trias

import androidx.lifecycle.MutableLiveData
import com.example.autoapp.utils.extensions.viewModel.ioToUi
import com.example.dinosaursapp.data.network.model.EnglishVersion
import com.example.dinosaursapp.data.network.model.Land
import com.example.dinosaursapp.data.network.model.RussianVersion
import com.example.dinosaursapp.domain.usecase.land.LandUseCase
import com.example.dinosaursapp.ui.base.AbsViewModel
import javax.inject.Inject

class TriassicViewModel @Inject constructor(
    private val landUseCase: LandUseCase
) : AbsViewModel() {

    val liveData = MutableLiveData<List<Land>>()

    fun fetch() {
        ioToUi(
            io = {
                when (landUseCase.getDinosaursList()) {
                    is EnglishVersion -> {
                        (landUseCase.getDinosaursList() as EnglishVersion).land
                            ?.filter {
                                it.detail!!.toLowerCase().contains("triassic") ||
                                        it.detail!!.toLowerCase().contains("perm")
                            }
                    }
                    else -> {
                        (landUseCase.getDinosaursList() as RussianVersion).land
                            ?.filter {
                                it.detail!!.toLowerCase().contains("триас") ||
                                        it.detail!!.toLowerCase().contains("перм")
                            }
                    }
                }
            },
            ui = {
                liveData.value = it
            }
        )
    }

    fun searchItem(title: String) {
        ioToUi(
            io = {
                when (landUseCase.getDinosaursList()) {
                    is EnglishVersion -> {
                        (landUseCase.getDinosaursList() as EnglishVersion).land
                            ?.filter { it.detail!!.toLowerCase().contains("triassic")
//                                    || it.detail!!.toLowerCase().contains("Perm")
                                    && it.title!!.toLowerCase().contains(title) }
                    }
                    else -> {
                        (landUseCase.getDinosaursList() as RussianVersion).land
                            ?.filter { it.detail!!.toLowerCase().contains("триас")
//                                    || it.detail!!.toLowerCase().contains("перм")
                                    && it.title!!.toLowerCase().contains(title) }
                    }
                }
            },
            ui = {
                liveData.value = it
            }
        )
    }
}