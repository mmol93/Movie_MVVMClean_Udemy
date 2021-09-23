package com.example.movie_mvvmclean_udemy.presentation.artist

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
import com.example.movie_mvvmclean_udemy.databinding.ActivityArtistBinding
import com.example.movie_mvvmclean_udemy.presentation.di.Injector
import com.example.movie_mvvmclean_udemy.presentation.tvShow.TVShowAdapter
import com.example.movie_mvvmclean_udemy.presentation.tvShow.TVShowViewModel
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistVieModel : ArtistViewModel
    private lateinit var adapter : ArtistAdapter
    lateinit var binder : ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistVieModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binder.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binder.artistRecyclerView.adapter = adapter
        displayPopularArtist()
    }

    private fun displayPopularArtist(){
        binder.artistProgressBar.isGone = false
        val responseLiveData = artistVieModel.getArtist()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binder.artistProgressBar.isGone = true
            }else{
                binder.artistProgressBar.isGone = true

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
                updateArtist()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtist(){
        binder.artistProgressBar.isGone = false
        val response = artistVieModel.updateArtist()
        response.observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binder.artistProgressBar.isGone = true
            }
        })
    }
}