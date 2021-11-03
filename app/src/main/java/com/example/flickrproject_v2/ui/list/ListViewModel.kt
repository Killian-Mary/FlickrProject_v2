package com.example.flickrproject_v2.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickrproject_v2.model.Photo
import com.example.flickrproject_v2.repository.Repository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel(){

    var photoList = MutableLiveData<List<Photo>>()

    init {
        viewModelScope.launch {

            val repository = Repository();
            val photosResult = repository.getPhotos().photos;
            photoList.value = photosResult.photo;


        }
    }
}