package com.example.flickrproject_v2.ui.full

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickrproject_v2.R
import com.example.flickrproject_v2.model.Photo
import com.example.flickrproject_v2.ui.list.ListViewModel
import com.example.flickrproject_v2.ui.list.MyAdapter

class FullFragment : Fragment() {
    companion object {
        fun newInstance() = FullFragment()
    }

    private lateinit var viewModel: FullViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val layout =  inflater.inflate(R.layout.fragment_full, container, false)
        viewModel = FullViewModel()
        var url: String = FullFragmentArgs.fromBundle(requireArguments()).url

        Log.e("URL", url)
        val ivFull = layout.findViewById<ImageView>(R.id.iv_full)
        Glide.with(layout).load(url).into(ivFull)


        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FullViewModel::class.java)
    }
}