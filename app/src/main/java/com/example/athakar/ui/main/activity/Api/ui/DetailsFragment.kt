package com.example.athakar.ui.main.activity.Api.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.activity.Api.AdapterScond.DetailsAdapter

class DetailsFragment : Fragment() {

    lateinit var recyclerView : RecyclerView


     val args :DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.rvDetails)


        // send data
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)

            recyclerView.adapter = args.details?.let { DetailsAdapter(it.details) }



    }


}