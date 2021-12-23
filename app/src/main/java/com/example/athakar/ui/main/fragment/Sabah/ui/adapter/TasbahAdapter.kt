package com.example.athakar.ui.main.fragment.Sabah.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.fragment.Sabah.ui.listTasbahFragmentDirections
import com.example.athakar.ui.main.fragment.Sabah.model.Tasbah


class TasbahAdapter(private val tasbahList:ArrayList<Tasbah>) : RecyclerView.Adapter<TasbahAdapter.tasbahViewHolder>() {




    class tasbahViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val tasbahName:TextView = view.findViewById(R.id.title_tasbah)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tasbahViewHolder {

        val view =LayoutInflater.from(parent.context)
                //هنا
            .inflate(R.layout.list_item,parent,false)
        return tasbahViewHolder(view)

    }

    override fun getItemCount(): Int = tasbahList.size


    override fun onBindViewHolder(holder: tasbahViewHolder, position: Int) {

        var tt = tasbahList[position].name_Tasbha
       holder.tasbahName.text = tt

         holder.itemView.setOnClickListener {

           var action = listTasbahFragmentDirections.actionListTasbahFragmentToSabahFragment(tt)

             it.findNavController().navigate(action)
            // findNavController().navigate(R.id.action_listTasbahFragment_to_sabahFragment)
            }
        // to on click lesser

           // fun onClick() {

        }



        }


