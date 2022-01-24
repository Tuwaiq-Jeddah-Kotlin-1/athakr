package com.example.athakar.ui.main.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.athakar.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore


class SigupFragment : Fragment() {


    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var confirm: EditText
    private lateinit var username: EditText
    private lateinit var signUp: Button
    private lateinit var backToSignIn: TextView
    private lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var ref: DatabaseReference
    private lateinit var  auth: FirebaseAuth
    private var Emale_pattern="[ a-zA-Z0-9._-]+@[a-z]+\\.+[a+z]+"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sigup, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = view.findViewById(R.id.edEmailRegister)
        pass = view.findViewById(R.id.edPassWordRegister)
        confirm = view.findViewById(R.id.edPassWordRegister2)
        username = view.findViewById(R.id.edProfile)
        signUp = view.findViewById(R.id.RegisterButton)
        backToSignIn = view.findViewById(R.id.tvloginlink)
       // skip = view.findViewById(R.id.Skip)

        firebaseFirestore  = FirebaseFirestore.getInstance()
        auth=FirebaseAuth.getInstance()

        //skip.setOnClickListener {
           // val action = SigupFragmentDirections.actionRegistrationActivityToHomeFragment()
          //  findNavController().navigate(action)
       // }

        backToSignIn.setOnClickListener {
            val action = SigupFragmentDirections.actionSigupFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        signUp.setOnClickListener {
            if (checkEmpty(arrayListOf(username, email, pass))) {
                if (confirm.text.toString() != pass.text.toString()) {
                    confirm.error = "Password mismatch"
                } else {
                    auth.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {


                                ref = FirebaseDatabase.getInstance().reference.child("Users")
                                    .child(auth.currentUser!!.uid)

                                val user = User(auth.currentUser!!.uid,username.text.toString(),email.text.toString())

                                firebaseFirestore.collection("users").document(auth.currentUser!!.uid)
                                    .set(user)
                                    .addOnSuccessListener {
                                        Log.d("TAG", "DocumentSnapshot successfully written!")
                                    }
                                    .addOnFailureListener { e ->
                                        Log.w("TAG", "Error writing document", e)
                                    }


                                Toast.makeText(context,
                                    "You've created new account Successfully",
                                    Toast.LENGTH_LONG)
                                    .show()

                                val action = SigupFragmentDirections.actionSigupFragmentToLoginFragment()
                                findNavController().navigate(action)

                            } else {
                                Toast.makeText(context,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_LONG)
                                    .show()
                            } }
                }
            }
        }

    }


    /////// test /////////

    fun email(email:String):Boolean{
        if (email.matches(Emale_pattern.toRegex()))
            return true
        return false
    }




//////// frist one ///////////

    fun checkEmpty(arrayListOf: ArrayList<EditText>): Boolean {
        var returnValue = false
        for (i in arrayListOf) {
            if (i.text.toString() == "") {
                i.error = "must be filled"
                returnValue = false
            } else {
                returnValue = true
            }
        }
        return returnValue
    }

}



