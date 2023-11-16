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

    fun onEvent(intent: NewsIntent) {
        when(intent) {
            NewsIntent.Load -> loadNews()
            is NewsIntent.LoadSection -> loadSectionNews(intent.section)
        }
    }

    @SuppressLint("CheckResult")
    private fun loadNews() {
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

    @SuppressLint("CheckResult")
    private fun loadSectionNews(section: String) {
        state = NewsState.Loading

        repository.getSectionNews(section)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    state = NewsState.News(articles = it, section = section)
                },{
                    state = NewsState.Error(errorMessage = it.message)
                }
            )
    }

    @SuppressLint("CheckResult")
    private fun loadSearchNews(section: String) {
        state = NewsState.Loading

        repository.getSearchNews(section)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    state = NewsState.News(articles = it, section = section)
                },{
                    state = NewsState.Error(errorMessage = it.message)
                }
            )
    }
}