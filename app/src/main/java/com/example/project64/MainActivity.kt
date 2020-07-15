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

        val DAY_LABEL: TextView? = findViewById<TextView>(R.id.dayLabel)
        val TIME_LABEL: TextView? = findViewById<TextView>(R.id.timeLabel)

//        INITIALISING TIME TABLE REPO OBJECT
        val TIME_TABLE_REPO = TimeTableRepo()
        var todaysCourses: MutableList<Subject> = TIME_TABLE_REPO.getTimeTableFor("Monday")
        var allCourses: MutableList<Subject> = TIME_TABLE_REPO.getTimeTableForAllCourses()

        val LIST_VIEW = findViewById<ListView>(R.id.subjectList)

        /* CREATING CUSTOM ADAPTER FOR SUBJECTS*/
        var todayCoursesAdapter = SubjectBaseAdapter(this, todaysCourses, "time")
        var allCoursesAdapter = SubjectBaseAdapter(this, allCourses, "day")

        var currentViewLabel = findViewById<TextView>(R.id.current_view)

        LIST_VIEW.adapter = todayCoursesAdapter


        val VIEW_PICKER = findViewById<RelativeLayout>(R.id.view_picker)
        VIEW_PICKER.setOnClickListener {
            if (TIME_LABEL != null) {
                TIME_LABEL.visibility = View.INVISIBLE
            }
            if (DAY_LABEL != null) {
                DAY_LABEL.visibility = View.INVISIBLE
            }
            if (LIST_VIEW.adapter == todayCoursesAdapter) {
                currentViewLabel.text = "All Course View"
                todayCoursesAdapter = SubjectBaseAdapter(this, todaysCourses, "time")
                allCoursesAdapter = SubjectBaseAdapter(this, allCourses, "day")
                todaysCourses = TIME_TABLE_REPO.getTimeTableFor("Monday")
                allCourses = TIME_TABLE_REPO.getTimeTableForAllCourses()
                LIST_VIEW.adapter = allCoursesAdapter
            } else {
                currentViewLabel.text = "Today's View"
                todayCoursesAdapter = SubjectBaseAdapter(this, todaysCourses, "time")
                allCoursesAdapter = SubjectBaseAdapter(this, allCourses, "day")
                todaysCourses = TIME_TABLE_REPO.getTimeTableFor("Monday")
                allCourses = TIME_TABLE_REPO.getTimeTableForAllCourses()
                LIST_VIEW.adapter = todayCoursesAdapter
            }

        }

    }
}