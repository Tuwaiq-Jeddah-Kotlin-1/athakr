package com.example.athakar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class ForgetpasswordFragment : Fragment() {

    private lateinit var edEmailLogin:TextView
    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgetpassword, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edEmailLogin = view.findViewById(R.id.edEmailLogin)
        login= view.findViewById(R.id.loginrButton)

              ///
        login.setOnClickListener {
            forgetPass()
        }
    }


        // the fun ///

    private fun forgetPass(){
        val email = edEmailLogin.text.toString().trim()
        /// check the email emapty//

        if (email.isEmpty()) {
            Toast.makeText(context,getString(R.string.please_enter_your_email),Toast.LENGTH_LONG).show()
        } else {
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        Toast.makeText(context, getString(R.string.email_sent),Toast.LENGTH_LONG).show()

                    } else {
                        Toast.makeText(context, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }

                }
        }
    }


}