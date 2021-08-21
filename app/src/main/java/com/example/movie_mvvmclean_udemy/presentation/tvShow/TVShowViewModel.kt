package com.example.movie_mvvmclean_udemy.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movie_mvvmclean_udemy.data.domain.usecase.GetTVShowUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.UpdateTvShowUseCase

class TVShowViewModel(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {
    fun getTVShow() = liveData {
        val TVShowList = getTVShowUseCase.execute()
        emit(TVShowList)
    }

    fun update() = liveData {
        val TVShow = updateTvShowUseCase.execute()
        emit(TVShow)
    }
}