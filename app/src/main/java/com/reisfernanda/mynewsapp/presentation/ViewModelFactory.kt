package com.reisfernanda.mynewsapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    viewModelProvider: Provider<NewsViewModel>
): ViewModelProvider.Factory {

    init {
        Log.d("* debug", "init ViewModelFactory")
    }

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        NewsViewModel::class.java to viewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}