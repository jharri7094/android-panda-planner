package edu.towson.cosc435.maddox.pandaplanner.model

data class Event (val name: String,
                  val timePeriod: String,
                  val details: String,
                  val isCompleted: Boolean,
                  val importanceRating: Int)

