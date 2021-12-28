package com.example.athakar.ui.main.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.athakar.R

class HomeFragment : Fragment() {

    private lateinit var homeFragment : HomeFragment
    private lateinit var athakarButtom:Button
    private lateinit var nameofButton:Button
    private lateinit var prayerTimeButton:Button
    private lateinit var quranButton:Button
    private lateinit var calenderButton:Button
    private lateinit var qiblaButton:Button
    private lateinit var nearmousqButton: Button
    private lateinit var OmrahButton:Button


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_home, container, false)

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        athakarButtom=view.findViewById(R.id.athakarButtom)
        athakarButtom.setOnClickListener {
               findNavController().navigate(R.id.action_homeFragment_to_athkarActivity) }


        calenderButton=view.findViewById(R.id.calenderButton)
        calenderButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_calenderFragment) }


         nameofButton=view.findViewById(R.id.nameofButton)
         nameofButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nameofFragment) }


        quranButton=view.findViewById(R.id.quranButton)
        quranButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_quranFragment) }


        qiblaButton=view.findViewById(R.id.qiblaButton)
        qiblaButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_qiblaFragment) }



        prayerTimeButton=view.findViewById(R.id.prayerTimeButton)
        prayerTimeButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_prayerTimeFragment) }



        nearmousqButton=view.findViewById(R.id.nearmousqButton)
        nearmousqButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nearmousqFragment) }


        OmrahButton=view.findViewById(R.id.OmrahButton)
        OmrahButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_omrahFragment) }


    }



    }




