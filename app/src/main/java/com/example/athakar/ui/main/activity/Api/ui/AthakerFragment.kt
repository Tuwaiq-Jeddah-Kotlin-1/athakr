package com.example.athakar.ui.main.activity.Api.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R


class AthakerFragment : Fragment() {

    lateinit var recyclerView : RecyclerView

    /// binding //
    private val vm by lazy {
        ViewModelProvider(this).get(MainVM::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_athaker, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.rvCategory)

        // send data
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        vm.fetchInterestingList().observe(viewLifecycleOwner){
            recyclerView.adapter = CategoryAdapter(it.athaker)
        }




    }

}