package com.example.movie_mvvmclean_udemy.data.repository.tvshow.remote_data

import com.example.movie_mvvmclean_udemy.data.api.TMDBService
import com.example.movie_mvvmclean_udemy.data.model.movie.MovieList
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVList
import retrofit2.Response

class TVShowRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apikey : String) : TVShowRemoteDataSource {
    // you can get movie data from Room database(@Get(~~))
    override suspend fun getTVShows(): Response<TVList> {
        return tmdbService.getPopularTvShow(apikey)
    }
}