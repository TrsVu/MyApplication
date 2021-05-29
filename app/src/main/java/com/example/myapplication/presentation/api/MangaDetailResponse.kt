package com.example.myapplication.presentation.api

data class MangaDetailResponse(
    val title: String,
    val synopsis:String,
    val genres: List<MangaGenre>,
    val url: String
)
data class MangaGenre(
    val mal_id:Int,
    val name: String,
    val url: String
)