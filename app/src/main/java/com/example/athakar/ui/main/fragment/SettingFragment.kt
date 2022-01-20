package com.example.athakar.ui.main.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat.recreate
import androidx.navigation.fragment.findNavController
import com.example.athakar.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_setting.*
import retrofit2.http.Url
import java.util.*

class SettingFragment : Fragment() {
    private lateinit var chagelangue:TextView
    private lateinit var shareApp: TextView
    private lateinit var logout: TextView
    private lateinit var edit:TextView

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
            Toast.makeText(context,"log out successful" ,Toast.LENGTH_SHORT).show()

            val action = SettingFragmentDirections.actionSettingFragmentToLoginFragment()
            findNavController().navigate(action)

        }


        edit=view.findViewById(R.id.editNmae)
        edit.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            findNavController().navigate(R.id.action_settingFragment_to_profileFragment)

        }


        //////SHARE APPP///////

        val url = "https://www.google.com/?client=safari&channel=mac_bm"

        shareApp = view.findViewById(R.id.shareapptext)
        shareApp.setOnClickListener {

            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra("share this link", url)
            val chooser = Intent.createChooser(intent, "share using ")
            startActivity(chooser)
        }


        chagelangue = view.findViewById(R.id.item_english)
        chagelangue.setOnClickListener {

            showLangDialog()

        }
    }

    fun showLangDialog() {
        val listLang = arrayOf("عربي", "English")
        val mBuilder = AlertDialog.Builder(context)
        mBuilder.setTitle("change languge")
        mBuilder.setPositiveButton("ok") { _, _ ->
            refreshCurrentFragment()
        }
        mBuilder.setSingleChoiceItems(listLang, -1) { dialog, which ->

            if (which == 0) {
                setLocale("ar")
            } else {
                setLocale("en")
            }
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    fun setLocale(lang: String){

        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        requireContext().resources.updateConfiguration(config, requireContext().resources.displayMetrics)

        val myPref = requireContext().getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = myPref.edit()

        editor.putString("MyLang",lang)
        //editor.commit()
        editor.apply()
        recreate(context as Activity)

    }

    private fun refreshCurrentFragment(){
        val id = findNavController().currentDestination?.id
        findNavController().navigateUp()
        findNavController().navigate(id!!)

        Log.e("Access","$id")
    }
}






