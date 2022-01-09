package com.example.athakar.ui.main.fragment.Sabah.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.fragment.Sabah.ui.listTasbahFragmentDirections
import com.example.athakar.ui.main.fragment.Sabah.model.Tasbah
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class TasbahAdapter( val tasbahList: MutableList<Tasbah>) : RecyclerView.Adapter<TasbahAdapter.tasbahViewHolder>() {


    class tasbahViewHolder(view:View):RecyclerView.ViewHolder(view) {
      var delett: ImageView = view.findViewById(R.id.iddelet)
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

        //// تخزين في متغير عشان اعرض الايتم
        var tt = tasbahList[position].name_Tasbha

           ///
        var dd=tasbahList[position].textId


         holder.tasbahName.text = tt
             // في حاله صارت اون كلك ليسنر علي الايتم
         holder.itemView.setOnClickListener {
            // هنا نقوله يرومج من اللسته الي السبحه (المسار الي راح يمشة)
           var action = listTasbahFragmentDirections.actionListTasbahFragmentToSabahFragment(tt)

             it.findNavController().navigate(action)
            // findNavController().navigate(R.id.action_listTasbahFragment_to_sabahFragment)
            }



        holder.delett.setOnClickListener {
           delete()
        }

        // to on click lesser

           // fun onClick() {

        }
    val uid = FirebaseAuth.getInstance().currentUser?.uid
    var db = FirebaseFirestore.getInstance()

    fun delete (){
        try {

            (uid?.let { it1 ->
                db.collection("users").document("$uid").collection("Tasbah").document(
                it1

                ).delete()
            }?.addOnSuccessListener {
              Log.e("ddd","succsess")
              //Toast.makeText("  ", "Successfully deleted image", Toast.LENGTH_SHORT).show()

            }?.addOnFailureListener {
               //  Toast.makeText(context, "failed to delete the image", Toast.LENGTH_SHORT).show()
                Log.e("ffff","ffff")

            })
        } catch (e: Exception) {
            Log.e("e","eeeee")

          //  Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()

        }
    }

        }


