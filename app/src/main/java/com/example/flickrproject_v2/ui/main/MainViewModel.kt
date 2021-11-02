package com.example.flickrproject_v2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickrproject_v2.model.Photo
import com.example.flickrproject_v2.repository.FlickrAPI
import com.example.flickrproject_v2.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var photo = MutableLiveData<Photo>()
    var photoList = ArrayList<Photo>();

    init {
        viewModelScope.launch {

            val repository = Repository();
            val photosResult = repository.getPhotos().photos;
            for (photo in photosResult.photo) {
                photoList.add(photo)
            }
            photo.value = photosResult.photo[0]
        }
    }

    fun nextPhoto() {
        val currentVal = photo.value
        var nextIndex: Int
        if(currentVal === null) {
            nextIndex = 0
        } else {
            val currentIndex = photoList.indexOf(currentVal)
            nextIndex = currentIndex + 1
            if(currentIndex === photoList.size - 1) {
                nextIndex = 0
            }
        }
        photo.value = photoList[nextIndex]
    }
}