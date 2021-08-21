package com.example.movie_mvvmclean_udemy.data.domain.usecase

import com.example.movie_mvvmclean_udemy.data.domain.repository.TVShowRepository
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow

class GetTVShowUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute() : List<TVShow>? = tvShowRepository.getTvShow()
}