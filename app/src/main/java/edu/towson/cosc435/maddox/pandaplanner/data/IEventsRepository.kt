package edu.towson.cosc435.maddox.pandaplanner.data

import edu.towson.cosc435.maddox.pandaplanner.model.Event

interface IEventsRepository {
    fun getEvents(): List<Event>
    fun deleteEvent(idx: Int)
    fun addEvent(event: Event)
    fun toggleCompleted(idx: Int)
}