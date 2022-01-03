package com.example.athakar.ui.main.activity.Api.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.athakar.R
import com.example.athakar.databinding.ActivityAthkarBinding
import com.example.athakar.ui.main.activity.Api.network.RetroBuilder
import com.example.athakar.ui.main.fragment.Sabah.ui.adapter.TasbahAdapter
import kotlinx.android.synthetic.main.item_category.*
import java.time.temporal.TemporalQuery


class AthkarActivity : AppCompatActivity() {

    lateinit var recyclerView :RecyclerView

    /// binding //
    private val vm by lazy {
        ViewModelProvider(this).get(MainVM::class.java)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_athkar)


        recyclerView=findViewById(R.id.rvCategory)
      // recyclerView.layoutManager =LinearLayoutManager()
      //  recyclerView.adapter = CategoryAdapter(item_text)


      //  vm.fetchInterestingList().observe(this, {


            //binding.rvCategory.adapter = CategoryAdapter(it.aktharMornig)
         //   Log.e("tag", it.athaker.toString())
         //   Log.e("tag", it.athaker[0].name.toString())



     //   }




    }


}




