package com.example.Artist_mvvmclean_udemy.data.repository.artist

import android.util.Log
import com.example.movie_mvvmclean_udemy.data.domain.repository.ArtistRepository
import com.example.movie_mvvmclean_udemy.data.model.artist.Artist
import com.example.movie_mvvmclean_udemy.data.repository.artist.remote_data.ArtistRemoteDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data.ArtistCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.local_data.ArtistLocalDataSource
import java.lang.Exception

// define repository's method with override
class ArtistRepositoryImpl(
    private val artistRemoteDataSource : ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    lateinit var ArtistList: List<Artist>

    override suspend fun getArtistShow(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtistShow(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromAPI() : List<Artist>{
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body != null){
                ArtistList = body.artists
            }
        }catch (e:Exception){
            Log.d("test", "getArtistsFromAPI: ${e.message.toString()}")
        }
        return ArtistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        try {
            ArtistList = artistLocalDataSource.getArtistFromDB()
        }catch (e:Exception){
            Log.d("test", "getArtistsFromDB: ${e.message.toString()}")
        }
        if (ArtistList.size > 0){
            return ArtistList
        }else{
            ArtistList = getArtistsFromAPI()
        }
        return ArtistList
    }

    suspend fun getArtistsFromCache() : List<Artist>{
        try {
            ArtistList =artistCacheDataSource.getArtistsFromCache()
        }catch (e:Exception){
            Log.d("test", "getArtistsFromCache: ${e.message.toString()}")
        }

        if (ArtistList.size > 0){
            return ArtistList
        }else{
            ArtistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(ArtistList)
        }
        return ArtistList
    }
}