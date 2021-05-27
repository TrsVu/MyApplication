package com.example.myapplication.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MangaListFragment : Fragment() {

    //private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private val adapter = MangaAdapter(listOf())

    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manga_list_fragment, container, false)
        // _binding = FragmentFirstBinding.inflate(inflater, container, false)
       // return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.manga_recyclerview)

        recyclerView.apply {
            layoutManager = this@MangaListFragment.layoutManager
            adapter = this@MangaListFragment.adapter
        }
            //binding.buttonFirst.setOnClickListener {
            //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            //}

        val mangaList: ArrayList<String> = arrayListOf<String>().apply {
            add("DBZ")
            add("Naruto")
            add("One piece")
        }
        adapter.updateList(mangaList)

    }
/*
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

 */
}