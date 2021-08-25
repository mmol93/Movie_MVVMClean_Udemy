package com.example.movie_mvvmclean_udemy.data.repository.movie

import android.util.Log
import com.example.movie_mvvmclean_udemy.data.domain.repository.MovieRepository
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie
import com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data.MovieCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.local_data.MovieLocalDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.remote_data.MovieRemoteDataSource
import java.lang.Exception

// define repository's method with override
class MovieRepositoryImpl(
    private val movieRemoteDataSource : MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    lateinit var movieList: List<Movie>

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI() : List<Movie>{
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null){
                movieList = body.movies
            }
        }catch (e:Exception){
            Log.d("test", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        try {
            movieList = movieLocalDataSource.getMovieFromDB()
        }catch (e:Exception){
            Log.d("test", e.message.toString())
        }
        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList =movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList=getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}