package com.reisfernanda.mynewsapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.reisfernanda.mynewsapp.domain.repository.NewsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {
    var state by mutableStateOf(NewsState())
        private set

    fun loadNews() {
        state = state.copy(
            isLoading = true,
            errorMessage = null,
            articles = null
        )

        repository.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    state = state.copy(
                        articles = it,
                        isLoading = false,
                        errorMessage = null
                    )
                },{
                    state = state.copy(
                        articles = null,
                        isLoading = false,
                        errorMessage = it.message
                    )
                }
            )
    }
}