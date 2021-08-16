package com.example.dinosaursapp.domain.usecase

import androidx.annotation.WorkerThread

@Suppress("UnnecessaryAbstractClass")
abstract class UseCaseParams<T, Params> {

    @WorkerThread
    abstract suspend fun execute(params: Params): T
}