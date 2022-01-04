package com.example.athakar.ui.main.fragment.Sabah.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.fragment.Sabah.model.Tasbah
import com.example.athakar.ui.main.fragment.Sabah.ui.adapter.TasbahAdapter


class listTasbahFragment : Fragment() {

    private lateinit var addTassbah: ImageView
    private lateinit var bacK_counter_page: ImageView
    private lateinit var rv_showData : RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_tasbah, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addTassbah = view.findViewById(R.id.addTassbah)
        addTassbah.setOnClickListener {
            findNavController().navigate(R.id.action_listTasbahFragment_to_addFragment) }

        bacK_counter_page = view.findViewById(R.id.bacK_counter_page)
        bacK_counter_page.setOnClickListener {
            findNavController().navigate(R.id.action_listTasbahFragment_to_sabahFragment) }

             /// rv///
        rv_showData=view.findViewById(R.id.rv_showData)

            // write a list here //

        var tasbah = arrayListOf(
            Tasbah( "أَسْتَغْفِرُ اللَّهَ "),
            Tasbah( " سُبْحَانَ اللَّهِ وَبِحَمْدِهِ"),
            Tasbah( "سُبْحَانَ اللَّهِ وَالْحَمْدُ لِلَّهِ"),
            Tasbah( "لَا إلَه إلّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلُّ شَيْءِ قَدِيرِ"),
            Tasbah( " لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِالله"),
            Tasbah( "الْحَمْدُ للّهِ رَبِّ الْعَالَمِينٌَ"),
            Tasbah( "الْلَّهُم صَلِّ وَسَلِم وَبَارِك عَلَى سَيِّدِنَا مُحَمَّد"),
            Tasbah( "لاَ إِلَهَ إِلاَّ اللَّهَ"),
            Tasbah( "اللهُ أكبرَ"),
            Tasbah( "سُبْحَانَ الْلَّهِ، وَالْحَمْدُ لِلَّهِ، وَلَا إِلَهَ إِلَّا الْلَّهُ، وَالْلَّهُ أَكْبَرَُ"),
            Tasbah( "سُبْحَانَ اللَّهِ ، وَالْحَمْدُ لِلَّهِ ، وَلا إِلَهَ إِلا اللَّهُ ، وَاللَّهُ أَكْبَرُ ، اللَّهُمَّ اغْفِرْ لِي ، اللَّهُمَّ ارْحَمْنِي ، اللَّهُمَّ ارْزُقْنِي"),
            Tasbah( "أَسْتَغْفِرُ اللَّهَ الْعَظِيمَ الَّذِي لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ ، وَأَتُوبُ إِلَيْهِ"),)

        /*
           rv_showData.apply {

              layoutManager = LinearLayoutManager(this@listTasbahFragment)
               adapter = TasbahAdapter(tasbah)

           }*/

            ///call the recycle view ////
        rv_showData.layoutManager = LinearLayoutManager(context)
        rv_showData.adapter = TasbahAdapter(tasbah)



           }




}


