package com.example.project64

import android.util.Log

class TimeTableRepo {
    val LOG_TAG: String = "Time Table Repo"

    fun getTimeTableFor(day: String): MutableList<Subject> {
        Log.i(LOG_TAG, "Fetching time table for $day")
        val SUBJECTS: MutableList<Subject> = mutableListOf()
        val NUMBER_OF_SUBJECTS: Int = (1..8).shuffled().first()
        for (i in 1..NUMBER_OF_SUBJECTS) {
            SUBJECTS.add(getFakeSubject())
        }
        return SUBJECTS
    }

    /* FOR ALL COURSE VIEW */
    fun getTimeTableForAllCourses(): MutableList<Subject> {
        val SUBJECTS: MutableList<Subject> = mutableListOf()
        val NUMBER_OF_SUBJECTS = 11
        for (i in 0..NUMBER_OF_SUBJECTS) {
            SUBJECTS.add(getFakeSubject())
        }
        return SUBJECTS
    }


    fun getFakeSubject(): Subject {
        var AM_PM = "AM"
        if ((0..1).shuffled().first() == 1)
            AM_PM = "PM"

        val DURATION: Int = (1..2).shuffled().first()
        val RANDOM_TIME = (1..12).shuffled().first()
        val START_HOUR: String = padWithZeros(2, RANDOM_TIME.toString())
        val END_HOUR: String = padWithZeros(2, (RANDOM_TIME + DURATION).toString())

        val MINUTE = padWithZeros(2, ((0..3).shuffled().first() * 15).toString())

        val START_TIME = "$START_HOUR:$MINUTE$AM_PM"
        val END_TIME = "$END_HOUR:$MINUTE$AM_PM"

        val ATTENDANCE = (50..100).shuffled().first()
        val NOTIFICATIONS = (1..10).shuffled().first()

        val subject = Subject(
            "SUBJECT NAME",
            ATTENDANCE,
            NOTIFICATIONS,
            START_TIME,
            END_TIME,
            listOf("M", "W", "Th")
        )
        Log.i(LOG_TAG, "$START_TIME $END_TIME")
        return subject
    }

    fun padWithZeros(length: Int, string: String): String {
        var returnString = string
        if (string.length < length) {
            for (i in 1..(length - string.length)) {
                returnString = "0$returnString"
            }
        }
        return returnString
    }
}