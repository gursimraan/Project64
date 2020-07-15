package com.example.project64

data class Subject(
    var name: String,
    var attendance: Int,
    var notifications: Int,
    var startTime: String,
    var endTime: String,
    var days: List<String>
)
