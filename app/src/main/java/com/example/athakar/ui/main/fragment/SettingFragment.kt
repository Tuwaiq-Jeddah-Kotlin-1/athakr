package com.example.athakar.ui.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.athakar.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SettingFragment : Fragment() {


    private lateinit var logout: TextView

    //var firebaseFirestore: FirebaseFirestore =FirebaseFirestore.getInstance()
    //lateinit var ref: DatabaseReference
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    //var firebaseUserId: String = auth.currentUser!!.uid


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logout = view.findViewById(R.id.logout)
        logout.setOnClickListener {
            auth.signOut()

            val action = SettingFragmentDirections.actionSettingFragmentToLoginFragment()
            findNavController().navigate(action)
        }


    }
}
