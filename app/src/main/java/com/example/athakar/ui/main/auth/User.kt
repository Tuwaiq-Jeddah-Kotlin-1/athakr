package com.example.athakar.ui.main.auth

import com.google.firebase.firestore.DocumentSnapshot

 data class User ( val user_id: String,
             var user_name: String,
             var user_email: String )
{
    companion object{

        fun DocumentSnapshot.toUser():User?{
            return try {
                val uid = getString("uid")!!
                var email = getString("email")!!
                var password = getString("password")!!
             User(uid, email, password)
            }catch (e:Exception){
                null
            }

        }

    }





}
