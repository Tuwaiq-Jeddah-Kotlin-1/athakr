package com.example.athakar.ui.main.activity.Api.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.databinding.ItemCategoryBinding
import com.example.athakar.ui.main.activity.Api.network.Categories
import com.example.athakar.ui.main.activity.Api.network.responceAkthar



class CategoryAdapter( val mylist: List<Categories>) :RecyclerView.Adapter<CategoryAdapter.CatViewHolder>() {

    class CatViewHolder(val binding :ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {

  return CatViewHolder(
      ItemCategoryBinding.inflate(
          LayoutInflater.from(parent.context)
          ,parent,
          false))
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {

        holder.binding.itemText.text = "kkkk"


    }


    override fun getItemCount()= mylist.size

}