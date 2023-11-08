package com.reisfernanda.mynewsapp.presentation

import android.annotation.SuppressLint
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
    var state by mutableStateOf<NewsState>(NewsState.Idle)
        private set

    @SuppressLint("CheckResult")
    fun loadNews() {
        state = NewsState.Loading

        repository.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    state = NewsState.News(articles = it)
                },{
                    state = NewsState.Error(errorMessage = it.message)
                }
            )
    }
}