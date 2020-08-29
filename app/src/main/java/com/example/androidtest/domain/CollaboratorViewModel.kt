package com.example.androidtest.domain

import androidx.lifecycle.ViewModel
import com.example.androidtest.interfaces.FileRepository
import com.example.androidtest.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class CollaboratorViewModel(
    val fileRepository: FileRepository,
    private val dispatcher:CoroutineDispatcher = Dispatchers.Main
) :BaseViewModel(dispatcher){



}