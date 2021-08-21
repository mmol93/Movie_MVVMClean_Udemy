package com.example.movie_mvvmclean_udemy.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie_mvvmclean_udemy.data.domain.usecase.GetTVShowUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.UpdateTvShowUseCase

class TVShowViewModelFactory(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowUseCase, updateTvShowUseCase) as T
    }
}