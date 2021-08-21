package com.example.movie_mvvmclean_udemy.data.repository.tvshow.cache_data

import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow

interface TvShowCacheDataSource {
    suspend fun saveTVShowsToCache(TvShows: List<TVShow>)

    suspend fun getTVShowFromCache():List<TVShow>
}