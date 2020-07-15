package com.example.project64

class TimeTableRepo {
    private val logTag: String = "Time Table Repo"
    private val days: List<String> = listOf("M", "T", "W", "Th", "F")

    /* FOR TODAY'S VIEW */
    fun getTimeTableFor(day: String): MutableList<Subject> {
        val subjects: MutableList<Subject> = mutableListOf()
        val numberOfSubjects: Int = (1..8).shuffled().first()
        for (i in 1..numberOfSubjects) {
            subjects.add(getFakeSubject())
        }
        return subjects
    }

    /* FOR ALL COURSE VIEW */
    fun getTimeTableForAllCourses(): MutableList<Subject> {
        val subjects: MutableList<Subject> = mutableListOf()
        val numberOfSubjects = 12
        for (i in 1..numberOfSubjects) {
            subjects.add(getFakeSubject())
        }
        return subjects
    }

    private fun getFakeSubject(): Subject {
        var amOrPm = "AM"
        if ((0..1).shuffled().first() == 1)
            amOrPm = "PM"

        val duration: Int = (1..2).shuffled().first()
        val randomTime = (1..12).shuffled().first()
        val startHour: String = padWithZeros(2, randomTime.toString())
        val endHour: String = padWithZeros(2, (randomTime + duration).toString())
        val minute = padWithZeros(2, ((0..3).shuffled().first() * 15).toString())
        val startTime = "$startHour:$minute$amOrPm"
        val endTime = "$endHour:$minute$amOrPm"

        val attendance = (50..100).shuffled().first()
        val notifications = (0..10).shuffled().first()

        val numberOfDays = (2..5).shuffled().first()

        var subjectName = ('a'..'z').shuffled()
            .subList(1, (6..14).shuffled().first())
            .joinToString("")
        subjectName = subjectName.get(0).toUpperCase()
            .toString() + subjectName.substring(1..subjectName.length - 1)

        val subject = Subject(
            subjectName,
            attendance,
            notifications,
            startTime,
            endTime,
            days.subList(0, numberOfDays)
        )
        return subject
    }

    private fun padWithZeros(length: Int, string: String): String {
        var returnString = string
        if (string.length < length) {
            for (i in 1..(length - string.length)) {
                returnString = "0$returnString"
            }
        }
        return returnString
    }
}