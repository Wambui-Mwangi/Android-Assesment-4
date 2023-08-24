package com.mwangi.assesment4.api

import com.mwangi.assesment4.model.Posts
import com.mwangi.assesment4.model.PostsResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
        @GET("/posts")
        suspend fun getPosts(): Response<PostsResponse>

}