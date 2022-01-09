package com.example.athakar.ui.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.athakar.R
import com.example.athakar.ui.main.activity.Api.AdapterScond.firestore
import com.example.athakar.ui.main.activity.Api.AdapterScond.usersId
import com.example.athakar.ui.main.activity.Api.model.responceAkthar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*

class FavoriteFragment : Fragment() {

       private lateinit var likelist:ArrayList<responceAkthar>
       private lateinit var favoriteAdapter: favoriteAdapter
       private lateinit var reycleview:RecyclerView

    var usersId = FirebaseAuth.getInstance().currentUser?.uid



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reycleview=view.findViewById(R.id.likerv)
        //----------------user RecyclerView-----------------------------------------
        reycleview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        reycleview.setHasFixedSize(true)
        likelist = arrayListOf()


        favorite(usersId.toString())

    }

    private fun favorite(usersId:String) {

        Toast.makeText(context, "hello 00 ", Toast.LENGTH_SHORT).show()

        firestore = FirebaseFirestore.getInstance()
        try {
           /* firestore.collection("users").document("BvwYO8uedNdWf9Ip4Th5esSt5xR2")
                    .collection("like")
                    .get()
                    .addOnSuccessListener {
                        var l = mutableListOf<responceAkthar>()
                        it.forEach {
                            it.toResponceAkthar()?.let { it2 ->
                                l.add(it2)
                            }
                          favoriteAdapter = favoriteAdapter(l)
                            reycleview.adapter = favoriteAdapter
                        }
                    }*/

        } catch (e: Exception) {

        }
        firestore.collection("users").document(usersId.toString())
            .collection("like")
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if (error != null) {
                        Log.e("Firestore", error.message.toString())
                        Toast.makeText(context, "hello 1 ", Toast.LENGTH_SHORT).show()
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!) {
                        if (dc.type == DocumentChange.Type.ADDED) {

                            likelist.add(dc.document.toObject(responceAkthar::class.java))
                        }
                    }

                }
            })

           // favoriteAdapter.notifyDataSetChanged()
    }


    }
