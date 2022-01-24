package com.example.athakar.ui.main.activity.Calender

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.athakar.R
import com.example.athakar.databinding.FragmentCalenderBinding
import com.github.eltohamy.materialhijricalendarview.CalendarDay
import com.github.eltohamy.materialhijricalendarview.MaterialHijriCalendarView
import com.github.eltohamy.materialhijricalendarview.OnDateSelectedListener
import java.util.*


class CalenderFragment : Fragment(), OnDateSelectedListener {

    private lateinit var hijri_date_tv: TextView
    private lateinit var calendarView: MaterialHijriCalendarView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calender, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        hijri_date_tv = view.findViewById(R.id.hijri_date_tv)
        hijri_date_tv.setOnClickListener {
            getSelectedDatesString()
        }



        calendarView = view.findViewById(R.id.calendarView)
        calendarView.setOnClickListener {
            calendarView.selectedDate = CalendarDay.today()
            calendarView.setOnDateChangedListener(this)
        }

    }

    override fun onDateSelected(
        widget: MaterialHijriCalendarView,
        date: CalendarDay,
        selected: Boolean
    ) {
        hijri_date_tv.text = getSelectedDatesString()
    }


    private fun getSelectedDatesString(): String? {
        val date: CalendarDay = calendarView.selectedDate

        return NumberHelper.getArabicNumber(date.calendar[Calendar.DAY_OF_MONTH]) + " " +
                date.calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale("ar")) +
                " " + NumberHelper.getArabicNumber(date.year) + " هــ"
    }
}