package com.example.athakar.ui.main.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.activity.Api.model.responceAkthar

class favoriteAdapter (private val articleList:List<responceAkthar>): RecyclerView.Adapter<favoriteAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_details,parent,false)

        return UserViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val likee =articleList[position]
        holder.titleArticle.text = likee.content


    }
    override fun getItemCount()=articleList.size


    class UserViewHolder(itemView : View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val titleArticle : TextView =itemView.findViewById(R.id.description)
        val articleCategory : TextView =itemView.findViewById(R.id.like)

        val image_article : ImageView = itemView.findViewById(R.id.reference)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {


        }
    }
}