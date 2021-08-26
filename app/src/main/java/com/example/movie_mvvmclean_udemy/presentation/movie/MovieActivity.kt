package com.example.movie_mvvmclean_udemy.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie_mvvmclean_udemy.R
import com.example.movie_mvvmclean_udemy.databinding.ActivityMovieBinding
import com.example.movie_mvvmclean_udemy.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieVieModel : MovieViewModel
    private lateinit var binder : ActivityMovieBinding
    private lateinit var adapter : MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieVieModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        binder.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binder.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binder.movieProgressBar.isGone = false
        val responseLiveData = movieVieModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binder.movieProgressBar.isGone = true
            }else{
                binder.movieProgressBar.isGone = true

                Toast.makeText(applicationContext, "There is no data", Toast.LENGTH_SHORT).show()
            }
            Log.d("test", it.toString())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateMovie()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovie(){
        binder.movieProgressBar.isGone = false
        val response = movieVieModel.updateMovies()
        response.observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binder.movieProgressBar.isGone = true
            }
        })
    }
}