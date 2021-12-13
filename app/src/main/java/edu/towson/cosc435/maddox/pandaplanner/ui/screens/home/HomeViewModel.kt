package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository
import edu.towson.cosc435.maddox.pandaplanner.data.IEventsRepository
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import kotlinx.coroutines.launch


class HomeViewModel(app : Application) : AndroidViewModel(app){
    private val _events: MutableState<List<Event>> = mutableStateOf(listOf())
    val events: State<List<Event>> = _events

    private val _repositoryEvent: IEventsRepository = EventsRepository(app = app)

    init{
        _events.value = _repositoryEvent.getDummyEvents()
    }

    fun addEvent(event: Event){
        viewModelScope.launch {
            _repositoryEvent.addEvent(event)
            _events.value = _repositoryEvent.getEvents()
        }
    }

    fun deleteEvent(idx: Int){
        _repositoryEvent.deleteDummyEvent(idx)
        _events.value = _repositoryEvent.getDummyEvents()
    }

    fun toggleCompleted(idx: Int){
        viewModelScope.launch {
            _repositoryEvent.toggleCompleted(_events.value[idx])
            _events.value = _repositoryEvent.getEvents()
        }

    }
}