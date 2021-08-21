package com.example.movie_mvvmclean_udemy.data.repository.tvshow.local_data

import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowFromDB() : List<TVShow>
    suspend fun saveTVShowToDB(TVShow:List<TVShow>)
    suspend fun clearAll()
}