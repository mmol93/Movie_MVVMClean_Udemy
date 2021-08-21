package com.example.movie_mvvmclean_udemy.data.repository.tvshow.cache_data

import com.example.movie_mvvmclean_udemy.data.model.movie.Movie
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var TVshowList = ArrayList<TVShow>()
    override suspend fun saveTVShowsToCache(TvShows: List<TVShow>) {
        TVshowList.clear()
        TVshowList = ArrayList(TvShows)
    }

    override suspend fun getTVShowFromCache(): List<TVShow> {
        return TVshowList
    }
}