package com.example.movie_mvvmclean_udemy.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movie_mvvmclean_udemy.data.domain.usecase.GetArtistUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {
    fun getArtist() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}