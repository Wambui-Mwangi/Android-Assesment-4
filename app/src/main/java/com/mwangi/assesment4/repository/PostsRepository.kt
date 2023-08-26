package com.mwangi.assesment4.repository

import com.mwangi.assesment4.api.ApiClient
import com.mwangi.assesment4.api.ApiInterface
import com.mwangi.assesment4.model.Posts
import com.mwangi.assesment4.model.PostsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getPosts(): Response<List<Posts>>{
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }
    }
}