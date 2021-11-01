package com.example.flickrproject_v2.model

class Photos(val page: Integer, val pages: Integer, val perpage: Integer,
             val total: String, val photo: List<Photo>){

}