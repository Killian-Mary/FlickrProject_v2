package com.example.flickrproject_v2.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickrproject_v2.R
import com.example.flickrproject_v2.model.Photo

class MyAdapter(val photoList : List<Photo>, val callback: (Int) -> Unit) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val v: GridLayout) : RecyclerView.ViewHolder(v) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyAdapter.MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.photo,parent,false)
        return MyViewHolder(layout as GridLayout)
    }

    override fun getItemCount(): Int = photoList.size

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        // Getting fields of photo usefull for URL
        val id:String = photoList[position].id
        val secret:String = photoList[position].secret
        val server:String = photoList[position].server

        // Getting ViewHolder
        val imageView = holder.v.findViewById<ImageView>(R.id.iv_photo)

        // URL
        var url:String =
            "https://live.staticflickr.com/" + server + "/" + id + "_" + secret + ".jpg"
        Glide.with(holder.v).load(url).into(imageView)
    }
}