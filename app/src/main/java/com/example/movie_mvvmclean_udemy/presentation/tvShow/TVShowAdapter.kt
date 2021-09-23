package com.example.movie_mvvmclean_udemy.presentation.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie_mvvmclean_udemy.R
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow
import com.example.movie_mvvmclean_udemy.databinding.ListItemBinding

class TVShowAdapter : RecyclerView.Adapter<MyViewHolder>(){
    private val tvList = ArrayList<TVShow>()

    fun setList(tvShows : List<TVShow>){
        tvList.clear()
        tvList.addAll(tvShows)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding(tvList[position])
    }

    override fun getItemCount(): Int {
        return tvList.size
    }
}

class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun binding(tvShow:TVShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview

        val posterURL = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}"
        Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
    }
}