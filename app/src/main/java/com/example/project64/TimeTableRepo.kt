package com.example.project64

class TimeTableRepo {
    private val LOG_TAG: String = "Time Table Repo"
    private val DAYS: List<String> = listOf("M", "T", "W", "Th", "F")

    /* FOR TODAY'S VIEW */
    fun getTimeTableFor(day: String): MutableList<Subject> {
        val SUBJECT: MutableList<Subject> = mutableListOf()
        val NUMBER_OF_SUBJECTS: Int = (1..8).shuffled().first()
        for (i in 1..NUMBER_OF_SUBJECTS) {
            SUBJECT.add(getFakeSubject())
        }
        return SUBJECT
    }

    /* FOR ALL COURSE VIEW */
    fun getTimeTableForAllCourses(): MutableList<Subject> {
        val SUBJECTS: MutableList<Subject> = mutableListOf()
        val NUMBER_OF_SUBJECTS = 12
        for (i in 1..NUMBER_OF_SUBJECTS) {
            SUBJECTS.add(getFakeSubject())
        }
        return SUBJECTS
    }

    private fun getFakeSubject(): Subject {
        var amOrPm = "AM"
        if ((0..1).shuffled().first() == 1)
            amOrPm = "PM"

        val DURATION: Int = (1..2).shuffled().first()
        val RANDOM_TIME = (1..12).shuffled().first()
        val START_HOUR: String = padWithZeros(2, RANDOM_TIME.toString())
        val END_HOUR: String = padWithZeros(2, (RANDOM_TIME + DURATION).toString())
        val MINUTE = padWithZeros(2, ((0..3).shuffled().first() * 15).toString())
        val START_TIME = "$START_HOUR:$MINUTE$amOrPm"
        val END_TIME = "$END_HOUR:$MINUTE$amOrPm"

        val ATTENDANCE = (50..100).shuffled().first()
        val NOTIFICATIONS = (0..10).shuffled().first()

        val NUMBER_OF_DAYS = (2..5).shuffled().first()

        var subjectName = ('a'..'z').shuffled()
            .subList(1, (6..14).shuffled().first())
            .joinToString("")
        subjectName = subjectName.get(0).toUpperCase()
            .toString() + subjectName.substring(1..subjectName.length - 1)

        val SUBJECT = Subject(
            subjectName,
            ATTENDANCE,
            NOTIFICATIONS,
            START_TIME,
            END_TIME,
            DAYS.subList(0, NUMBER_OF_DAYS)
        )
        return SUBJECT
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