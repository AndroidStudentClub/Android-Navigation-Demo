package com.example.android.demo.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.book_details_fragment.*

/**
 * A simple [Fragment] subclass.
 */
class BookDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.book_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookTitle = requireArguments().getString("title")
        val book = MockBooksRepository().getBooks().find { it.title == bookTitle }
        title.text = book?.title
        subtitle.text = book?.author
        description.text = book?.desc

        Glide.with(requireContext())
            .load(book?.imageUrl)
            .into(cover_image)
    }
}