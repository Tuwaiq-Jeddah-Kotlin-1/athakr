package com.example.athakar.ui.main.auth


import com.google.common.truth.Truth.assertThat
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SigupFragmentTest{

 private lateinit var sigup: SigupFragment

  @Before
 fun setup(){
     sigup = SigupFragment()
 }

     @Test
   fun checkEmail(){
       val result= sigup.email("test1234@gmail.com")

        assertThat(result)  }

}