package com.example.athakar.ui.main.activity.Api.AdapterScond

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.activity.Api.model.Categories
import com.example.athakar.ui.main.activity.Api.model.responceAkthar
import com.example.athakar.ui.main.activity.Api.ui.CategoryAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*
var firestore = FirebaseFirestore.getInstance()
var usersId = FirebaseAuth.getInstance().currentUser?.uid



class DetailsAdapter (val detailsList: List<responceAkthar>): RecyclerView.Adapter<DetailsAdapter.DetViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_details, parent, false)
        return DetailsAdapter.DetViewHolder(view)

    }

    override fun onBindViewHolder(holder: DetViewHolder, position: Int) {

        val o = detailsList[position]

        holder.zakerDetails.text = o.content
        holder.zakercount.text = o.count
        holder.zakerreference.text = o.reference
        holder.zakerdescription.text = o.description


        ///// like
        holder.like.setOnClickListener {
            holder.updatelike(o.content, o.count, o.content)

        }


        firestore.collection("users").document(usersId.toString()).collection("like")
            .document(o.content.toString()).get()
            .addOnCompleteListener {
                if (it.result?.exists()!!) {
                    holder.like.setImageResource(R.drawable.ic_baseline_favorite_24)

                } else {
                    holder.like.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }



    }


    override fun getItemCount() = detailsList.size


    class DetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val zakerDetails: TextView = view.findViewById(R.id.Categories_text)
        val zakercount: TextView = view.findViewById(R.id.counter)
        val zakerreference: TextView = view.findViewById(R.id.reference)
        val zakerdescription: TextView = view.findViewById(R.id.description)
        val like: ImageView = view.findViewById(R.id.like)




        fun updatelike(name: String, counterday: String, idzaker: String) {

            firestore.collection("users").document(usersId.toString()).collection("like")
                .document(idzaker.toString()).get()
                .addOnCompleteListener {
                    if (it.result?.exists()!!) {
                        like.setImageResource(R.drawable.ic_baseline_favorite_border_24)

                        deletezaker(idzaker,usersId.toString())
                    } else {

                        addzaker(name,counterday,idzaker)
                        like.setImageResource(R.drawable.ic_baseline_favorite_24)
                    }
                }


        }

        private fun addzaker(name: String, counterday: String, idzaker: String) {

            val addFavorite = hashMapOf(
                "namezaker" to name,
                "counterday" to counterday,
                "id" to idzaker
            )
            Log.e("tag", "add like")
            firestore.collection("users").document(usersId.toString())
                .collection("like").document(idzaker).set(addFavorite)

        }


        //---------deleteFavorite------------------------------------------------------------------------------------------
        fun deletezaker(zakerid: String, usersid: String) {
            firestore.collection("users").document(usersid)
                .collection("like").document(zakerid.toString()).delete()
                .addOnCompleteListener {
                    when {
                        it.isSuccessful -> {
                            Log.e("Delete Article ", "Delete From Articles Favorite")
                        }
                    }
                }
        }

    }

}