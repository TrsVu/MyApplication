package com.example.myapplication.presentation.list


data class Manga(
    val title: String,
    val mal_id:Int,
    val url:String,
    val image_url:String,
    val volumes: Int,
    val start_date: String
)