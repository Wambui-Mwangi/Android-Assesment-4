package com.mwangi.assesment4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mwangi.assesment4.databinding.ActivityMainBinding
import com.mwangi.assesment4.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {
    val postsViewModel:PostsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        postsViewModel.fetchPosts()

        postsViewModel.errLiveData.observe(this, Observer { err->
            Toast.makeText(baseContext, err, Toast.LENGTH_SHORT).show()
        })

        postsViewModel.postsLiveData.observe(this, Observer { postsList->
            binding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvPosts.adapter = RVAdapter(postsList, this)
        })
    }
}
