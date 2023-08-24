package com.mwangi.assesment4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mwangi.assesment4.model.Posts
import com.mwangi.assesment4.repository.PostsRepository
import kotlinx.coroutines.launch


class PostsViewModel:ViewModel() {
    val postsRepo = PostsRepository()
    val postsLiveData = MutableLiveData<List<Posts>>()
    val errLiveData = MutableLiveData<String>()

    fun fetchPosts(){
        viewModelScope.launch {
            val response = postsRepo.getPosts()
            if (response.isSuccessful){
                postsLiveData.postValue(response.body()?.posts)
            }else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}