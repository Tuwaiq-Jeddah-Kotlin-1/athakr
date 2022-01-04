package com.example.athakar.ui.main.fragment

import android.content.Intent
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
import retrofit2.http.Url

class SettingFragment : Fragment() {
    private lateinit var shareApp: TextView
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
            //////SHARE APPP///////

            val url ="https://www.google.com/?client=safari&channel=mac_bm"

            shareApp = view.findViewById(R.id.shareapptext)
            shareApp.setOnClickListener {

                var intent = Intent(Intent.ACTION_SEND)
                intent.type="text/plain"
                intent.putExtra("share this link",url)
                val chooser =Intent.createChooser(intent,"share using ")
                startActivity(chooser)
            }


        }
    }


