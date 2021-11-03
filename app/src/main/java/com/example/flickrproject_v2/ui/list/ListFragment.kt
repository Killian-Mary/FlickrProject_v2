package com.example.flickrproject_v2.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickrproject_v2.R
import com.example.flickrproject_v2.model.Photo
import com.example.flickrproject_v2.ui.main.MainFragment
import com.example.flickrproject_v2.ui.main.MainViewModel

class ListFragment : Fragment() {
    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val layout =  inflater.inflate(R.layout.fragment_list, container, false)
        viewModel = ListViewModel()

        viewModel.photoList.observe(viewLifecycleOwner, Observer { photoList ->
            run {
                val recycler = layout.findViewById<RecyclerView>(R.id.rv_imageList)

                // GridLayoutManager (context, int) : int = number of columns
                recycler.layoutManager = GridLayoutManager(requireActivity(), 2)
                recycler.adapter = MyAdapter(photoList) { position -> {
                }
                }
            }

        })
        var url: String = ""

        // Observer
        val observer = Observer<List<Photo>> { photo ->
        }
        viewModel.photoList.observe(viewLifecycleOwner, observer)

        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
    }
}