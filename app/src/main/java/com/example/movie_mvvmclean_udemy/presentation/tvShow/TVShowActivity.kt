package com.example.movie_mvvmclean_udemy.presentation.tvShow

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
import com.example.movie_mvvmclean_udemy.databinding.ActivityTvshowBinding
import com.example.movie_mvvmclean_udemy.presentation.di.Injector
import com.example.movie_mvvmclean_udemy.presentation.movie.MovieViewModel
import javax.inject.Inject

class TVShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TVShowViewModelFactory
    private lateinit var tvShowVieModel : TVShowViewModel
    lateinit var binder : ActivityTvshowBinding
    private lateinit var adapter : TVShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_tvshow)
        (application as Injector).createTVShowSubComponent()
            .inject(this)

        tvShowVieModel = ViewModelProvider(this, factory).get(TVShowViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binder.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TVShowAdapter()
        binder.tvshowRecyclerView.adapter = adapter
        displayPopularTVShows()
    }

    private fun displayPopularTVShows(){
        binder.tvshowProgressBar.isGone = false
        val responseLiveData = tvShowVieModel.getTVShow()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binder.tvshowProgressBar.isGone = true
            }else{
                binder.tvshowProgressBar.isGone = true

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
                updateTVShow()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTVShow(){
        binder.tvshowProgressBar.isGone = false
        val response = tvShowVieModel.update()
        response.observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binder.tvshowProgressBar.isGone = true
            }
        })
    }
}