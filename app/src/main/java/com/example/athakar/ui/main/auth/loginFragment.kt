package com.example.athakar.ui.main.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.athakar.R
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.fragment.findNavController


class loginFragment : Fragment() {


    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var signIn: Button
    private lateinit var createAccount: TextView
    private lateinit var forget: TextView
    private lateinit var skip: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = view.findViewById(R.id.edEmailLogin)
        pass = view.findViewById(R.id.edPassWordLogin)
        signIn = view.findViewById(R.id.loginrButton)
        createAccount = view.findViewById(R.id.CreateAccount)
        skip= view.findViewById(R.id.skip)
        forget= view.findViewById(R.id.forgetpassword)



        skip.setOnClickListener {
            val action = loginFragmentDirections.actionLoginFragmentToHomeFragment()
            findNavController().navigate(action)

        }




        forget.setOnClickListener {
            val action = loginFragmentDirections.actionLoginFragmentToForgetpasswordFragment()
            findNavController().navigate(action)

        }



       val currentUser = auth.currentUser
        if(currentUser != null ){
            val action = loginFragmentDirections.actionLoginFragmentToHomeFragment()
            findNavController().navigate(action)
      }

        createAccount.setOnClickListener {
            val action = loginFragmentDirections.actionLoginFragmentToSigupFragment()
            findNavController().navigate(action)
        }

        signIn.setOnClickListener {
            if (checkEmpty(arrayListOf(email, pass))) {

                auth.signInWithEmailAndPassword(email.text.toString(), pass.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {

                            //val firebaseUser: FirebaseUser = task.result!!.user!!
                            Toast.makeText(
                                context,
                                "Signed in Successfully",
                                Toast.LENGTH_LONG
                            )
                                .show()

                            val action =
                               loginFragmentDirections.actionLoginFragmentToHomeFragment()
                            findNavController().navigate(action)

                        } else {
                            Toast.makeText(
                                context,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    }
            }
        }
    }


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


