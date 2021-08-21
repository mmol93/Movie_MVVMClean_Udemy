package com.example.movie_mvvmclean_udemy.data.domain.usecase

import com.example.movie_mvvmclean_udemy.data.domain.repository.ArtistRepository
import com.example.movie_mvvmclean_udemy.data.model.artist.Artist

// get data from repository
class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() : List<Artist>? = artistRepository.getArtistShow()
}