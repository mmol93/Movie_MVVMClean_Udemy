package com.example.movie_mvvmclean_udemy.data.repository.tvshow.remote_data

import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows() : Response<TVList>
}