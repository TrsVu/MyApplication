package com.example.myapplication.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.presentation.Singletons
import com.example.myapplication.presentation.api.MangaDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MangaDetailFragment : Fragment() {

    private lateinit var textViewName: TextView
    private lateinit var textViewSynopsis: TextView
    private lateinit var textViewUrl: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_manga_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName= view.findViewById(R.id.manga_detail_name)
        textViewSynopsis=view.findViewById(R.id.manga_detail_synopsis)
        textViewUrl=view.findViewById(R.id.manga_detail_url)
        callApi()
    }
    private fun callApi(){
        val id = arguments?.getInt("mangaId")?:-1
        Singletons.mangaApi.getMangaDetail(id).enqueue(object : Callback<MangaDetailResponse>{
            override fun onResponse(
                call: Call<MangaDetailResponse>,
                response: Response<MangaDetailResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    textViewName.text = response.body()!!.title
                    textViewSynopsis.text = response.body()!!.synopsis
                    textViewUrl.text = getString(R.string.infos)
                    textViewUrl.setOnClickListener {

                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(response.body()!!.url)))
                    }
                }

            }

            override fun onFailure(call: Call<MangaDetailResponse>, t: Throwable) {

            }

        })
    }

}