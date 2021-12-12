package edu.towson.cosc435.maddox.pandaplanner.model

data class Event(
    val startDate: String,
    val endDate: String,
    val eventName: String,
    val eventDetails: String,
    val priority: String,
    val isCompleted: Boolean
)

