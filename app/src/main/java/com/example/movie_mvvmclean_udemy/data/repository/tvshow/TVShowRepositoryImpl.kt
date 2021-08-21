package com.example.movie_mvvmclean_udemy.data.repository.tvshow

import android.util.Log
import com.example.movie_mvvmclean_udemy.data.domain.repository.TVShowRepository
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.cache_data.TvShowCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.local_data.TVShowLocalDataSource
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.remote_data.TVShowRemoteDataSource
import java.lang.Exception

// define repository's method with override
class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource : TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TVShowRepository {
    lateinit var tvShowList: List<TVShow>

    override suspend fun getTvShow(): List<TVShow>? {
        return getTVShowsFromCache()
    }

    override suspend fun updateTvShow(): List<TVShow>? {
        val newListOfMovies = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowToDB(newListOfMovies)
        tvShowCacheDataSource.saveTVShowsToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getTVShowsFromAPI() : List<TVShow>{
        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            if (body != null){
                tvShowList = body.TVShows
            }
        }catch (e:Exception){
            Log.d("test", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTVShowsFromDB():List<TVShow>{
        try {
            tvShowList = tvShowLocalDataSource.getTVShowFromDB()
        }catch (e:Exception){
            Log.d("test", e.message.toString())
        }
        if (tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTVShowsFromAPI()
        }
        return tvShowList
    }

    suspend fun getTVShowsFromCache() : List<TVShow>{
        try {
            val response = tvShowCacheDataSource.getTVShowFromCache()
        }catch (e:Exception){
            Log.d("test", e.message.toString())
        }

        if (tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShowList)
        }
        return tvShowList
    }


}