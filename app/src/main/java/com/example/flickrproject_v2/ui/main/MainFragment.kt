package com.example.flickrproject_v2.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.flickrproject_v2.R
import com.example.flickrproject_v2.R.layout.main_fragment
import com.example.flickrproject_v2.model.Photo
import com.example.flickrproject_v2.ui.list.ListFragmentDirections

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        var url: String = ""
        val layout =  inflater.inflate(main_fragment, container, false)
        val nextButton = layout.findViewById<Button>(R.id.btn_next)
        val allButton = layout.findViewById<Button>(R.id.btn_allImages)
        val imageTitle = layout.findViewById<TextView>(R.id.tv_title)
        val imageView = layout.findViewById<ImageView>(R.id.iv_central)
        var urlForFull = ""
        // Observer
        val observer = Observer<Photo> { photo ->
            val url = "https://farm" + photo.farm + ".staticflickr.com/" + photo.server + "/" + photo.id+"_"+photo.secret + ".jpg"
            urlForFull = url
            imageTitle.text = photo.title
            Glide.with(layout).load(url).into(imageView)
        }
        viewModel.photo.observe(viewLifecycleOwner, observer)

        // Next image
        nextButton.setOnClickListener {
            viewModel.nextPhoto()
        }

        // Navigation
        allButton.setOnClickListener {
            Navigation.findNavController(layout).navigate(R.id.main_to_list)
        }
        
        imageView.setOnClickListener{
            val action = MainFragmentDirections.mainToFull(urlForFull)
            Navigation.findNavController(layout).navigate(action)
        }

        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

}