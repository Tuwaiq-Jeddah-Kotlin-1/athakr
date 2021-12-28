package com.example.athakar.ui.main.activity.Athkar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.databinding.ItemCategoryBinding
import com.example.athakar.ui.main.activity.Athkar.AthkarActivity


class CategoryAdapter( val athkarActivity: AthkarActivity, val list: ArrayList<String>) :RecyclerView.Adapter<CategoryAdapter.CatViewHolder>() {

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
        holder.binding.itemText.text = list[position].toString()

    }

    override fun getItemCount()= list.size

}