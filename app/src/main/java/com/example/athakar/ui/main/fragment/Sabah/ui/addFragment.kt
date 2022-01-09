package com.example.athakar.ui.main.fragment.Sabah.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.athakar.R
import com.example.athakar.ui.main.activity.Api.ui.DetailsFragmentArgs
import com.example.athakar.ui.main.fragment.Sabah.model.Tasbah
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_list_tasbah.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class addFragment : Fragment() {

  var db= FirebaseFirestore.getInstance()
  val uid =FirebaseAuth.getInstance().currentUser?.uid

    ////fire base
//    private val sabah =Firebase.firestore.collection("users").document( "$uid")
//        .collection("Tasbah").set()


    lateinit  var add:Button
    lateinit var addtv:EditText
    private lateinit var delet:Button
    private lateinit var updata:Button
    private lateinit var retrave:Button


    val args : addFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        add = view.findViewById(R.id.btnadd)
        addtv = view.findViewById(R.id.textviewadd)


        add.setOnClickListener {
          //  val action = addFragmentDirections.actionAddFragmentToListTasbahFragment(addtv.text.toString())
            val tesbah=Tasbah(name_Tasbha = addtv.text.toString())
           save(tesbah)
            findNavController().navigate(R.id.action_addFragment_to_listTasbahFragment)

        }


        delet = view.findViewById(R.id.btndelet)

        delet.setOnClickListener {
            Toast.makeText(context, "delet button", Toast.LENGTH_SHORT).show()




        }


        updata = view.findViewById(R.id.btnupdata)
        updata.setOnClickListener {

            Toast.makeText(context, "updatra button", Toast.LENGTH_SHORT).show()

        }

        retrave = view.findViewById(R.id.btnretrive)

        retrave.setOnClickListener {

            try {

                (uid?.let { it1 ->
                    db.collection("Tasbah").document(
                        it1
                    ).delete()
                }?.addOnSuccessListener {
                    Toast.makeText(context, "Successfully deleted image", Toast.LENGTH_SHORT).show()

                }?.addOnFailureListener {
                    Toast.makeText(context, "failed to delete the image", Toast.LENGTH_SHORT).show()

                })
            } catch (e: Exception) {

                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()

            }

            Toast.makeText(context, "reteve button", Toast.LENGTH_SHORT).show()

        }


        return  view
    }

    fun save (tesbah : Tasbah){
        db.collection("users").document( "$uid").collection("Tasbah").document("${tesbah.textId}")
            .set(tesbah)
    }


}