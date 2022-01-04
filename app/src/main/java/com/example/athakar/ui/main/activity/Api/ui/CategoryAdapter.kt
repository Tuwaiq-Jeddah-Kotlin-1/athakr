package com.example.athakar.ui.main.activity.Api.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.activity.Api.model.Categories



class CategoryAdapter( val mylist:List<Categories>) :RecyclerView.Adapter<CategoryAdapter.CatViewHolder>() {

    class CatViewHolder(view:View) : RecyclerView.ViewHolder(view) {


        val zakerName: TextView = view.findViewById(R.id.item_text)




    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {

         val view = LayoutInflater.from(parent.context)
             //هنا
             .inflate(R.layout.item_category ,parent,false)
         return CatViewHolder(view)



    }


    override fun onBindViewHolder(viewHolder: CatViewHolder, position: Int) {

        val CAT = mylist[position]
         viewHolder.zakerName.text = CAT.name

       viewHolder.itemView.setOnClickListener {

          var action = AthakerFragmentDirections.actionAthakerFragmentToDetailsFragment(CAT)
           it.findNavController().navigate(action)

       }

    }

        override fun getItemCount()= mylist.size
}