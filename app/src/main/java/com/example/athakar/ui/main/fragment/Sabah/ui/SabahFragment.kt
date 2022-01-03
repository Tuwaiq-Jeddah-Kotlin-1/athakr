package com.example.athakar.ui.main.fragment.Sabah.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.ButtonBarLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.athakar.R


class SabahFragment : Fragment() {

    // lateinit var binding: FragmentSabahBinding

     private lateinit var display: ImageView
     private lateinit var incrementtext: TextView
     private lateinit var restButton: Button
     private lateinit var athakerkind:TextView


    val arg: SabahFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sabah, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding = FragmentSabahBinding.inflate(layoutInflater)

       athakerkind = view.findViewById(R.id.athakerkind)

       athakerkind.text= arg.tzaker.toString()
//        if(arg){
//            athakerkind.text= " nathk"
//        }else{
//            athakerkind.text= arg.tzaker.toString()
//        }



         display= view.findViewById(R.id.display)
         display.setOnClickListener {
        findNavController().navigate(R.id.action_sabahFragment_to_listTasbahFragment) }


              // counter code

             var increament_number =0

      incrementtext = view.findViewById(R.id.incrementtext)
      incrementtext.setOnClickListener {

            increament_number ++

        incrementtext.text = increament_number.toString()

          }

               // rest buttom code

        restButton = view.findViewById(R.id.reset)
        restButton.setOnClickListener {

            increament_number =0
            incrementtext.text = increament_number.toString()

             }

    }
}