package com.example.athakar.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.athakar.R
import com.example.athakar.ui.main.activity.Api.AdapterScond.usersId
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.updata.*
import kotlinx.android.synthetic.main.updata.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class profileFragment : Fragment() {

    private lateinit var usernameTV:TextView
    private lateinit var userEmailtv:TextView
    private lateinit var done: Button

    val db = FirebaseFirestore.getInstance()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        done = view.findViewById(R.id.updata)

        usernameTV=view.findViewById(R.id.textView4)
        userEmailtv=view.findViewById(R.id.textViewname)


        done.setOnClickListener {


            upDateUserInfoBottomSheet(usernameTV.text.toString())

        }

        getUserInfo()

    }


    private fun upDateUserInfoBottomSheet(userPhoneNumber:String) {
        val view: View = layoutInflater.inflate(R.layout.updata, null)
        val builder = BottomSheetDialog(requireView().context as Context)
        builder.setTitle("Up Date Information")

        val upDateInfoButton = view.upDateInfoButton_xml


        val username=view.findViewById<TextInputEditText>(R.id.editTextTextUserName)
       username.setText(usernameTV.text.toString())
     //  val editTextPhone=  view.editTextPhone.setText(userPhoneNumber)

        upDateInfoButton.setOnClickListener {



                db.collection("users").document(usersId.toString()).update("user_name",username.text.toString())
                builder.dismiss()
            usernameTV.setText(username.text.toString())

            Toast.makeText(context, "hello ${username.text.toString()}", Toast.LENGTH_SHORT).show()

        }
        builder.setContentView(view)
        builder.show()
    }


    fun getUserInfo() {

        var usersId = FirebaseAuth.getInstance().currentUser?.uid

        try {
            //coroutine

            db.collection("users").document("${usersId.toString()}")
                .get().addOnCompleteListener {
                    it
                    if (it.result?.exists()!!) {
                        //+++++++++++++++++++++++++++++++++++++++++
                        var name = it.result!!.getString("user_name")
                        var userEmail = it.result!!.getString("user_email")


                        usernameTV.setText(name)
                        userEmailtv.setText(userEmail)
                        Toast.makeText(context, "name ${name}", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.e("error \n", "errooooooorr")
                    }
                }
        } catch (e: Exception) {

        }
    }

}