package com.example.myapplication.presentation.api

import com.example.myapplication.presentation.list.Manga

data class MangaListResponse(
    val top: List<Manga>
)
