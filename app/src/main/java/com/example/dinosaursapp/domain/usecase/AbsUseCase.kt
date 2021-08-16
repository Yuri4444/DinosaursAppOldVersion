package com.example.dinosaursapp.domain.usecase

import androidx.annotation.WorkerThread

abstract class AbsUseCase<T> {

    @WorkerThread
    abstract suspend fun execute(): T
}