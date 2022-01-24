package com.example.athakar.ui.main.fragment

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
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.athakar.R
import com.google.firebase.auth.FirebaseAuth

import java.util.*

class SettingFragment : Fragment() {
    private lateinit var chagelangue:TextView
    private lateinit var shareApp: TextView
    private lateinit var logout: TextView
    private lateinit var edit:TextView
    private lateinit var imglog:ImageView
    private lateinit var imgpro:ImageView

    //var firebaseFirestore: FirebaseFirestore =FirebaseFirestore.getInstance()
    //lateinit var ref: DatabaseReference
    val auth = FirebaseAuth.getInstance()
    val auth1 = FirebaseAuth.getInstance().currentUser?.uid

    //var firebaseUserId: String = auth.currentUser!!.uid


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_setting, container, false)



        /////logout ////

        logout = view.findViewById(R.id.logout)
        imglog=view.findViewById(R.id.logoutimag)

        if(auth1 != null) {

            logout.setOnClickListener {
                auth.signOut()

                Toast.makeText(
                    context,
                    "log out successful",
                    Toast.LENGTH_SHORT
                )
                    .show()
                val action = SettingFragmentDirections.actionSettingFragmentToLoginFragment()
                findNavController().navigate(action)
            }
        }
            else{
                logout.visibility=View.GONE
                imglog.visibility=View.GONE  }


//
//        }else {
////
//            logout.setOnClickListener {
//                auth.signOut()
//
//                Toast.makeText(
//                    context,
//                    "log out successful ${auth1.toString()}",
//                    Toast.LENGTH_SHORT
//                )
//                    .show()
//                val action = SettingFragmentDirections.actionSettingFragmentToLoginFragment()
//                findNavController().navigate(action)
//            }
//        }
//          if(auth1 != null){
//
//      logout.visibility=View.GONE
//       imglog.visibility=View.GONE
//     }

        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//              }            }else{
//          logout.visibility=View.GONE
//          imglog.visibility=View.GONE



       // Toast.makeText(context, "hello${FirebaseAuth.getInstance().currentUser!!.uid}", Toast.LENGTH_SHORT).show()

        ///edit profile

        edit=view.findViewById(R.id.editNmae)
        imgpro=view.findViewById(R.id.imgpro)
//

         if(auth1 != null){
//
           edit.setOnClickListener {
//
              findNavController().navigate(R.id.action_settingFragment_to_profileFragment)

           }
        }else{
//
           edit.visibility=View.GONE
           imgpro.visibility=View.GONE
        }



//        edit=view.findViewById(R.id.editNmae)
//        imgpro=view.findViewById(R.id.imgpro)
//
//        edit.setOnClickListener {
//
//               findNavController().navigate(R.id.action_settingFragment_to_profileFragment)
//         }

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
        editor.commit()
       // editor.apply()
      //  recreate(context as Activity)

    }

    private fun refreshCurrentFragment(){
        val id = findNavController().currentDestination?.id
        findNavController().navigateUp()
        findNavController().navigate(id!!)

        Log.e("Access","$id")
    }
}






