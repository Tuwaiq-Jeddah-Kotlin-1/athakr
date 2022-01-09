package com.example.athakar.ui.main.fragment.Sabah.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.ui.main.fragment.Sabah.model.Tasbah
import com.example.athakar.ui.main.fragment.Sabah.ui.adapter.TasbahAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class listTasbahFragment : Fragment() {


    private lateinit var addTassbah: ImageView
    private lateinit var bacK_counter_page: ImageView
    private lateinit var rv_showData: RecyclerView
    private lateinit var tasbah: TasbahAdapter
    private var listSize: Int = 0
    var db = FirebaseFirestore.getInstance()


    // val uid = FirebaseAuth.getInstance().currentUser?.uid
    private lateinit var firbase: FirebaseAuth
    val uid = FirebaseAuth.getInstance().currentUser?.uid


    val args: listTasbahFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list_tasbah, container, false)




    return view
    }







    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        addTassbah = view.findViewById(R.id.addTassbah)
        addTassbah.setOnClickListener {
            findNavController().navigate(R.id.action_listTasbahFragment_to_addFragment)
        }

        bacK_counter_page = view.findViewById(R.id.bacK_counter_page)
        bacK_counter_page.setOnClickListener {
            findNavController().navigate(R.id.action_listTasbahFragment_to_sabahFragment)
        }






        /// rv///
        rv_showData = view.findViewById(R.id.rv_showData)

        // write a list here //

        var tasbah = mutableListOf(
            Tasbah("أَسْتَغْفِرُ اللَّهَ "),
            Tasbah(" سُبْحَانَ اللَّهِ وَبِحَمْدِهِ"),
            Tasbah("سُبْحَانَ اللَّهِ وَالْحَمْدُ لِلَّهِ"),
            Tasbah("لَا إلَه إلّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلُّ شَيْءِ قَدِيرِ"),
            Tasbah(" لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِالله"),
            Tasbah("الْحَمْدُ للّهِ رَبِّ الْعَالَمِينٌَ"),
            Tasbah("الْلَّهُم صَلِّ وَسَلِم وَبَارِك عَلَى سَيِّدِنَا مُحَمَّد"),
            Tasbah("لاَ إِلَهَ إِلاَّ اللَّهَ"),
            Tasbah("اللهُ أكبرَ"),
            Tasbah("سُبْحَانَ الْلَّهِ، وَالْحَمْدُ لِلَّهِ، وَلَا إِلَهَ إِلَّا الْلَّهُ، وَالْلَّهُ أَكْبَرَُ"),
            Tasbah("سُبْحَانَ اللَّهِ ، وَالْحَمْدُ لِلَّهِ ، وَلا إِلَهَ إِلا اللَّهُ ، وَاللَّهُ أَكْبَرُ ، اللَّهُمَّ اغْفِرْ لِي ، اللَّهُمَّ ارْحَمْنِي ، اللَّهُمَّ ارْزُقْنِي"),
            Tasbah("أَسْتَغْفِرُ اللَّهَ الْعَظِيمَ الَّذِي لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ ، وَأَتُوبُ إِلَيْهِ"),

        )

        var textList: MutableLiveData<MutableList<Tasbah>> = MutableLiveData()
        var textListIn = mutableListOf<Tasbah>()

        rv_showData.layoutManager = LinearLayoutManager(context)

          db.collection("users").document("$uid").collection("Tasbah")
              .get()

            .addOnCompleteListener()
            {
                it.addOnSuccessListener { snapshot ->
                    snapshot?.let { docSnap ->
                        var documents = docSnap.documents
                        documents.forEach { documents ->
                            var textObj = documents.toObject(Tasbah::class.java)
                            textObj?.let {
                                Log.d("text Obj", textObj.toString())

                                textListIn.add(textObj)
                                Log.d("text textListIn", textListIn.toString())
                            }
                        }
                        rv_showData.adapter = TasbahAdapter(textListIn)
                        textList.value = textListIn
                        Log.d("text List", textList.toString())
                        println("----------111")
                        println(textList)
                    }
                }
            }



        if (args.addnew != null) {
           tasbah.add(Tasbah(args.addnew.toString()))


        }


        // var add = arrayListOf(o)


        /*
           rv_showData.apply {

              layoutManager = LinearLayoutManager(this@listTasbahFragment)
               adapter = TasbahAdapter(tasbah)

           }*/


        ///call the recycle view ////


        //  rv_showData.adapter = TasbahAdapter(args.addnew.toString())




//
//        fetchText(viewLifecycleOwner).observe(viewLifecycleOwner, {
//
//
//            listSize = it.size
//            rv_showData.adapter =TasbahAdapter(tasbah)
//        })

    }









//            db.collection("users").document("$uid").collection("Tasbah").get()
//                .addOnCompleteListener() {
//                    it.addOnSuccessListener { snapshot ->
//                        snapshot?.let { docSnap ->
//                            var documents = docSnap.documents
//                            documents.forEach { documents ->
//                                var textObj = documents.toObject(Tasbah::class.java)
//
//
//                                textObj?.let {
//                                    Log.d("text Obj", textObj.toString())
//                                    textListIn.add
//                                    Log.d("text textListIn", textListIn.toString())
//                                }
//                            }
//                            textList.value = textListIn
//                            Log.d("text List", textList.toString())
//                        }
                   // }
               //  }

             // return textList

    //}

}






