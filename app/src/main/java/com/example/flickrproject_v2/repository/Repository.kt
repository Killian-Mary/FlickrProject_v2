package com.example.flickrproject_v2.repository

import com.example.flickrproject_v2.model.SearchResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import android.util.Log.INFO


class Repository {
    suspend fun getPhotos(): SearchResult {
        val url = "https://www.flickr.com"
        val retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create()).build()
        val service = retrofit.create(FlickrAPI::class.java)
        return service.getInterestingPhotos(
            "flickr.interestingness.getList",
            "34b3c6c1b435ac9b6b4206e3ca8bc32d",
            "20"
        )
    }
}

