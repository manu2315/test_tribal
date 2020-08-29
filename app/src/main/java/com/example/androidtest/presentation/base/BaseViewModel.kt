package com.example.androidtest.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(private val dispatcher: CoroutineDispatcher) :ViewModel(),CoroutineScope{

    /**Corutines Begins**/
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = job+dispatcher
    private val coroutineScope= CoroutineScope(dispatcher+job)
    fun getCoroutineScope(): CoroutineScope =coroutineScope
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
    /**Corutines Ends**/
}