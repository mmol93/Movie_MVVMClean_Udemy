package com.example.movie_mvvmclean_udemy.data.repository.tvshow.local_data

import com.example.movie_mvvmclean_udemy.data.database.MovieDao
import com.example.movie_mvvmclean_udemy.data.database.TVShowDao
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao : TVShowDao) : TVShowLocalDataSource {
    override suspend fun getTVShowFromDB(): List<TVShow> {
        return tvShowDao.getTVShows()
    }

    override suspend fun saveTVShowToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTVShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.clearTvShow()
        }
    }
}