package com.example.athakar.ui.main.fragment.Sabah.ui

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
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
    private lateinit var athakerkind: TextView

    private val preferencesTasbah by lazy {
        this.requireActivity().getSharedPreferences("preference", Context.MODE_PRIVATE)
    }


    val arg: SabahFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sabah, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding = FragmentSabahBinding.inflate(layoutInflater)

        athakerkind = view.findViewById(R.id.athakerkind)

        athakerkind.text = arg.tzaker.toString()
//        if(arg){
//            athakerkind.text= " nathk"
//        }else{
//            athakerkind.text= arg.tzaker.toString()
//        }


        display = view.findViewById(R.id.display)
        display.setOnClickListener {
            findNavController().navigate(R.id.action_sabahFragment_to_listTasbahFragment)
        }


        // counter code


        var increament_number = 0
        val counterTAS = preferencesTasbah.getInt("counter", 100)
        incrementtext = view.findViewById(R.id.incrementtext)
        incrementtext.setOnClickListener {

            increament_number++
            preferencesTasbah.edit().putInt("counter", increament_number).apply()
            //val counterTAS = preferencesTasbah.getInt("counter",100)

            //incrementtext.text = increament_number.toString()
            //incrementtext.text = counterTAS.toString()


            if (increament_number ==10) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(context, "اسرع في الجنة قريبة", Toast.LENGTH_SHORT).show()
            } else if (increament_number == 20) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(context, "بينك  و بين الجنة يقف ملك الموت ", Toast.LENGTH_SHORT)
                    .show()
            } else if (increament_number == 30) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(
                    context, "ايها المنافق لماذا لا تجتهد في التسبيح   ",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (increament_number == 40) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(
                    context, "هنيا لك اصبحت مسيلمة الكذاب ",
                    Toast.LENGTH_SHORT).show()
            }else if (increament_number == 50) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(
                    context, "لم يتبقي للجنة سوي 50 حسنة ",
                    Toast.LENGTH_SHORT).show()
            }
            else if (increament_number == 60) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(
                    context, "اسرع اسرع في نار جهنم تحرق  ",
                    Toast.LENGTH_SHORT).show()
            }else if (increament_number == 70) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(
                    context, "ان ابليس يمعنك من الاكمال",
                    Toast.LENGTH_SHORT).show()
            }else if (increament_number == 80) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(
                    context, "هل تعلم ان ادم كان في الجنة ",
                    Toast.LENGTH_SHORT).show()
            }else if (increament_number == 90) {
                incrementtext.text = increament_number.toString()
                Toast.makeText(
                    context, "لقد هزمت ابليس ",
                    Toast.LENGTH_SHORT).show()
            }else { (increament_number <  100)
                incrementtext.text = increament_number.toString()
                Toast.makeText(
                    context, "لقد فاتك مقعدك بجانب ابو لهب في النار  ",
                    Toast.LENGTH_SHORT).show()
            }




            // rest buttom code

            restButton = view.findViewById(R.id.reset)
            restButton.setOnClickListener {

                increament_number = 0
                incrementtext.text = increament_number.toString()
                //incrementtext.text = counterTAS.toString()
            }

        }
    }
}