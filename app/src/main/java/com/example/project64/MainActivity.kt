package com.example.project64

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todays_view)

        val dayLabel: TextView? = findViewById<TextView>(R.id.dayLabel)
        val timeLabel: TextView? = findViewById<TextView>(R.id.timeLabel)

//        INITIALISING TIME TABLE REPO OBJECT
        val timeTableRepo = TimeTableRepo()
        val subjects: MutableList<Subject> = timeTableRepo.getTimeTableForAllCourses()

        val listView = findViewById<ListView>(R.id.subjectList)

        /* CREATING CUSTOM ADAPTER FOR SUBJECTS*/
        val timeBaseAdapter = SubjectBaseAdapter(this, subjects, "time")
        val dayBaseAdapter = SubjectBaseAdapter(this, subjects, "day")

        listView.adapter = timeBaseAdapter


        val viewPicker = findViewById<RelativeLayout>(R.id.view_picker)
        viewPicker.setOnClickListener {
            if (timeLabel != null) {
                timeLabel.visibility = View.INVISIBLE
            }
            if (dayLabel != null) {
                dayLabel.visibility = View.INVISIBLE
            }
            if (listView.adapter == timeBaseAdapter)
                listView.adapter = dayBaseAdapter
            else
                listView.adapter = timeBaseAdapter

        }

    }
}