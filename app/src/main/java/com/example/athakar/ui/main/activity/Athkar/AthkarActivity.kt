package com.example.athakar.ui.main.activity.Athkar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.athakar.databinding.ActivityAthkarBinding
import com.example.athakar.ui.main.activity.Athkar.adapter.CategoryAdapter

class AthkarActivity : AppCompatActivity() {

    /// binding //

    lateinit var binding: ActivityAthkarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAthkarBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ////    نبدا في تعريف الاري عشان اقسام الاذكار

        val list = arrayListOf<String>(" اذكار الصباح ", " اذكار المساء ", " اذكار المسجد", "اذكار الصلاة", " اذكارالنوم ", " اذكار الاستقياظ من النوم" )

           // linked
        binding.rvCategory.layoutManager = LinearLayoutManager(this)

       binding.rvCategory.adapter = CategoryAdapter(this,list)

    }



    }
