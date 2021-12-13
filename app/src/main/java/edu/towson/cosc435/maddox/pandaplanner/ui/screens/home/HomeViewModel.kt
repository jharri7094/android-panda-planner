package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository
import edu.towson.cosc435.maddox.pandaplanner.data.IEventsRepository
import edu.towson.cosc435.maddox.pandaplanner.model.Event


class HomeViewModel(app : Application) : AndroidViewModel(app){
    private val _events: MutableState<List<Event>> = mutableStateOf(listOf())
    val events: State<List<Event>> = _events

    private val _selectedEvent: MutableState<Event?> = mutableStateOf(null)
    val selectedEvent = _selectedEvent

    private val _repositoryEvent: IEventsRepository = EventsRepository(app = app)

    init{
        _events.value = _repositoryEvent.getDummyEvents()
    }

    fun addEvent(event: Event){
        _repositoryEvent.addDummyEvent(event)
        _events.value = _repositoryEvent.getDummyEvents()
    }

    fun deleteEvent(idx: Int){
        _repositoryEvent.deleteDummyEvent(idx)
        _events.value = _repositoryEvent.getDummyEvents()
    }

    fun toggleCompleted(idx: Int){
        _repositoryEvent.toggleDummyCompleted(idx)
        _events.value = _repositoryEvent.getDummyEvents()
    }

    fun selectEvent(event: Event){
        _selectedEvent.value = event
    }
}