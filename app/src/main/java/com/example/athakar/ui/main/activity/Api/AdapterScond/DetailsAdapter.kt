package com.example.athakar.ui.main.activity.Api.AdapterScond

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.activity.Api.model.Categories
import com.example.athakar.ui.main.activity.Api.model.responceAkthar
import com.example.athakar.ui.main.activity.Api.ui.CategoryAdapter


class DetailsAdapter (val detailsList: List<responceAkthar>): RecyclerView.Adapter<DetailsAdapter.DetViewHolder>()
{
    class DetViewHolder (view: View): RecyclerView.ViewHolder(view) {

        val zakerDetails: TextView = view.findViewById(R.id.Categories_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_details ,parent,false)
        return DetailsAdapter.DetViewHolder(view)

    }

    override fun onBindViewHolder(holder: DetViewHolder, position: Int) {

        val o =  detailsList[position]

         holder.zakerDetails.text = o.content.toString()

        holder.itemView.setOnClickListener {



        }

    }

    override fun getItemCount()= detailsList.size

    }

