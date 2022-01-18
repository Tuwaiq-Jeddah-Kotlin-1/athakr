package com.example.athakar.ui.main.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.athakar.R


class HomeFragment : Fragment() {



    private lateinit var athakarButtom: Button
    private lateinit var calenderButton: Button
    private lateinit var qiblaButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        athakarButtom = view.findViewById(R.id.athakarButtom)
        athakarButtom.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_athakerFragment)
        }


        calenderButton = view.findViewById(R.id.calenderButton)
        calenderButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_calenderFragment)
        }

           qiblaButton = view.findViewById(R.id.qiblaButton)
           qiblaButton.setOnClickListener {
          findNavController().navigate(R.id.action_homeFragment_to_qublahActivity) }


        }

    }








