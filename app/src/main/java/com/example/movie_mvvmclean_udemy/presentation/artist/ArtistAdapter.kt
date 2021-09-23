package com.example.movie_mvvmclean_udemy.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie_mvvmclean_udemy.R
import com.example.movie_mvvmclean_udemy.data.model.artist.Artist
import com.example.movie_mvvmclean_udemy.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<MyViewHolder>(){
    private val artistList = ArrayList<Artist>()

    fun setList(artists : List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun binding(artist:Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()

        val posterURL = "https://image.tmdb.org/t/p/w500${artist.profilePath}"
        Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
    }
}