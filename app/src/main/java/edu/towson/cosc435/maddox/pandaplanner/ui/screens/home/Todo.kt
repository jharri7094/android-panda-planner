package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

data class Todo (
    val name: String,
    val timePeriod: String,
    val details: String,
    val isCompleted: Boolean,
    val importanceRating: Int
){
}