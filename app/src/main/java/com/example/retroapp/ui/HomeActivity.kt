package com.example.retroapp.ui

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retroapp.R
import com.example.retroapp.adapters.MainAdapter
import com.example.retroapp.network.Characters
import com.example.retroapp.util.Resource
import com.example.retroapp.viewModels.MainActivityViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by lazy{
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(mainToolbar as Toolbar?)
        supportActionBar?.title = "Retrofit Example"



        viewModel.characterLiveDatas.observe(this,{characters->
            processResponse(characters)


        })
    }

    private fun processResponse(state:Resource<List<Characters>?>){
        when(state){
            is Resource.Loading->{
                progressBar.visibility=VISIBLE
            }
            is Resource.Success->{
                progressBar.visibility=View.GONE
                if (state.data!=null){
                    val adapters= MainAdapter(state.data)
                    mainRecycler.apply {
                        adapter=adapters
                        layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                    }

                }

            }
            is Resource.Error->{
                progressBar.visibility=View.GONE
                val view=progressBar.rootView
                Snackbar.make(view, state.message!!,Snackbar.LENGTH_LONG).show()

            }

        }
    }
}