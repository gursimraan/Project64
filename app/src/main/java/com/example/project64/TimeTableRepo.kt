package com.example.project64

import android.util.Log

class TimeTableRepo {
    val tagMsg: String = "Time Table Repo"

    fun getTimeTableFor(day: String): MutableList<Subject> {
        Log.i(tagMsg, "Fetching time table for $day")
        val subjects: MutableList<Subject> = mutableListOf()
        subjects.add(
            Subject(
                "Introduction to Programming Paradigms",
                87,
                4,
                "09:00AM",
                "10;30",
                listOf("M", "T", "F")
            )
        )
        subjects.add(
            Subject(
                "Relational Database Management",
                84,
                0,
                "10:45",
                "12:00",
                listOf("W", "Th")
            )
        )
        subjects.add(
            Subject(
                "Computer Networks",
                76,
                3,
                "12:15AM",
                "01;30",
                listOf("M", "Th", "F")
            )
        )
        return subjects
    }
}