package com.example.myapplication.presentation

import com.example.myapplication.presentation.MangaApplication.Companion.context
import com.example.myapplication.presentation.api.MangaApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons(){
    companion object{

        var cache = Cache( File(context?.cacheDir, "responses"),  10 * 1024 * 1024)// 10 MiB

        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()
        val mangaApi: MangaApi = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
             .client(okHttpClient)
            .build().create(MangaApi::class.java)


    }
}
