package com.example.movie_mvvmclean_udemy.data.domain.repository

import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow

interface TVShowRepository{
    // get Movie data
    suspend fun getTvShow() : List<TVShow>?

    // update Movie data
    suspend fun updateTvShow() : List<TVShow>?
}