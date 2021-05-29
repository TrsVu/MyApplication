package com.example.myapplication.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MangaApi {
    @GET("top/manga")
    fun getMangaList(): Call<MangaListResponse>

    @GET("manga/{id}")
    fun getMangaDetail(@Path("id") id: Int): Call<MangaDetailResponse>
}