package edu.towson.cosc435.maddox.pandaplanner.data

import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.model.User

interface IEventsRepository {
//    fun getDummyEvents(): List<Event>
//    fun deleteDummyEvent(idx: Int)
//    fun addDummyEvent(event: Event)
//    fun toggleDummyCompleted(idx: Int)

    fun setUserId(id : Long)
    suspend fun getUserId(username: String, password: String): Long?
    suspend fun insertNewUser(user : User)
    suspend fun deleteEvent(event: Event)
    suspend fun updateEvent(event : Event)
    suspend fun addEvent(event: Event)
    fun returnUserId(): Long
    fun getHomeEvents(): List<Event>
    fun getAllEvents() : List<Event>
    suspend fun fetchEvents()
}