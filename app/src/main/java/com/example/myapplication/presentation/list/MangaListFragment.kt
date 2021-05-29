package com.example.myapplication.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.Singletons
import com.example.myapplication.presentation.api.MangaListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MangaListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = MangaAdapter(listOf(), ::onClickedManga)



    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manga_list_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.manga_recyclerview)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = this@MangaListFragment.adapter
        }
        Singletons.mangaApi.getMangaList().enqueue(object : Callback<MangaListResponse> {
            override fun onFailure(call: Call<MangaListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<MangaListResponse>,
                response: Response<MangaListResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val mangaResponse: MangaListResponse = response.body()!!
                    adapter.updateList(mangaResponse!!.top)

                }
            }



        })

    }

    private fun onClickedManga(id: Int) {
        findNavController().navigate(R.id.navigateToMangaDetailFragment, bundleOf(
            "mangaId" to (id)

        ))
    }
}