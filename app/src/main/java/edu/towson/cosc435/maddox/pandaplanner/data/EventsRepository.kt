package edu.towson.cosc435.maddox.pandaplanner.data

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.db.DB
import edu.towson.cosc435.maddox.pandaplanner.db.PandaDAO
import edu.towson.cosc435.maddox.pandaplanner.model.User

class EventsRepository(app : Application): IEventsRepository {

    private var masterList : List<Event> = listOf()

    private val dao : PandaDAO = DB.getDatabase(app).pandaDAO()

    private val userId : MutableState<Long?> = mutableStateOf(null)
    override fun setUserId(id: Long) {
        userId.value = id
    }

    override suspend fun getUserId(username : String, password : String) : Long? {
        userId.value = dao.getUserId(username = username, password = password)
        return userId.value
    }

    override fun returnUserId() : Long{
        return userId.value!!
    }

    override fun getHomeEvents(): List<Event> {
        return masterList.filter{event -> !event.isCompleted}
    }

    override fun getAllEvents(): List<Event> {
        return masterList
    }

    override suspend fun deleteEvent(event : Event){
        dao.deleteEvent(event)
    }

    override suspend fun updateEvent(event : Event){
        dao.updateEvent(event)
    }

    override suspend fun addEvent(event: Event) {
        dao.insertNewEvent(event)
    }

    override suspend fun fetchEvents() {
        masterList = dao.getEvents(userId = userId.value!!)
    }


    override suspend fun insertNewUser(user: User) {
        dao.insertNewUser(user = user)
    }

//    private var _dummyEvents : List<Event> = listOf()
//    private var _originalDummyEventList : List<Event> = listOf()

//    override fun getDummyEvents(): List<Event> {
//         _originalDummyEventList = (0..10).map { i ->
//            Event(eventName = "Event $i", startDate = i.toString(), endDate = (i+i).toString(), eventDetails = "event event $i", isCompleted = i%2==0, priority = Priority.HIGH.toString(), userId = i.toLong())
//        }
//        return _dummyEvents
//    }

//    // Dummy testing functions
//    override fun getDummyEvents() : List<Event> {
//        return _dummyEvents
//    }
//
//    override fun deleteDummyEvent(idx : Int){
//        _dummyEvents = _dummyEvents.subList(0, idx) + _dummyEvents.subList(idx + 1, _dummyEvents.size)
//    }
//
//    override fun addDummyEvent(event : Event){
//        _dummyEvents = listOf(event) + _dummyEvents
//    }
//
//    override fun toggleDummyCompleted(idx : Int){
//        val event = _dummyEvents[idx]
//        val newEvent = event.copy(isCompleted = !event.isCompleted)
//        _dummyEvents = _dummyEvents.subList(0, idx) + listOf(newEvent) + _dummyEvents.subList(idx + 1, _dummyEvents.size)
//    }
}
