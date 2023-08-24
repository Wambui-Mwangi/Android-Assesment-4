package com.mwangi.assesment4.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mwangi.assesment4.databinding.PostsListItemBinding
import com.mwangi.assesment4.model.Posts


class RVAdapter(var postsList: List<Posts>, var context:Context): RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var binding = PostsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var post = postsList[position]
        var binding = holder.binding
        binding.tvTitle.text = post.title
        binding.tvBody.text = post.body

    }

    override fun getItemCount(): Int {
        return postsList.size
    }
}

class PostsViewHolder(var binding: PostsListItemBinding): RecyclerView.ViewHolder(binding.root)