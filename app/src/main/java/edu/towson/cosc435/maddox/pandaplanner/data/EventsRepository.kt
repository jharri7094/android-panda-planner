package edu.towson.cosc435.maddox.pandaplanner.data

import android.app.Application
import edu.towson.cosc435.maddox.pandaplanner.model.Event

class EventsRepository(app : Application): IEventsRepository {
    private var _events: List<Event>
    private val _originalEventList: List<Event> = (0..3).map { i ->
        Event("Event $i", "12am - 12pm", "This is a dummy task",
        "false", "4", false)
    }

    init{
        _events = _originalEventList.map{ s -> s }
    }

    override fun getEvents(): List<Event> {
        return _events
    }
    override fun deleteEvent(idx: Int){
        _events = _events.subList(0, idx) + _events.subList(idx + 1, _events.size)
    }
    override fun addEvent(event: Event){
        _events = listOf(event) + _events
    }
    override fun toggleCompleted(idx: Int){
        val event = _events.get(idx)
        val newEvent = event.copy(eventDetails = event.eventDetails)
        val _events = _events.subList(0, idx) + listOf(newEvent) +
                _events.subList(idx + 1, _events.size)
    }
}