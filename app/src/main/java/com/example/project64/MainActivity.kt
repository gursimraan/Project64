package com.example.project64

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todays_view)

//        INITIALISING TIME TABLE REPO OBJECT
        val timeTableRepo = TimeTableRepo()
        val subjects: MutableList<Subject> = timeTableRepo.getTimeTableFor("Tuesday")

//        EXAMPLE
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setOnClickListener { view ->
            (
                    Log.i(
                        "Something",
                        "${subjects.get(1).name} has ${subjects.get(1).notifications}"
                    )
                    )
        }
    }
}