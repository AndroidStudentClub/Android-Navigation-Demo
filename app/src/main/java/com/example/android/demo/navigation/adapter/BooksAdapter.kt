package com.example.android.demo.navigation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.demo.navigation.Book
import com.example.android.demo.navigation.R

class BooksAdapter(
    private val movies: List<Book>,
    private val rowLayout: Int,
    private val onClick: () -> Unit
) : RecyclerView.Adapter<BooksAdapter.MovieViewHolder>() {
    class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var bookTitle: TextView = v.findViewById(R.id.title)
        internal var bookDescription: TextView = v.findViewById(R.id.description)
        internal var author: TextView = v.findViewById(R.id.subtitle)
        internal var imageView: ImageView = v.findViewById(R.id.cover_image)
        internal val container: LinearLayout = v.findViewById(R.id.books_layout)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val current = movies[position]
        holder.container.setOnClickListener { onClick.invoke() }
        holder.bookTitle.text = current.title
        holder.author.text = current.author
        holder.bookDescription.text = current.desc
        Glide.with(holder.bookTitle.context)
            .load(current.imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
