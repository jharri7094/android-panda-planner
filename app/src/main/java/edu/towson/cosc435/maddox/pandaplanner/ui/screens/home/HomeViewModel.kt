package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.maddox.pandaplanner.data.IEventsRepository
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import kotlinx.coroutines.launch


class HomeViewModel(app : Application, private val repo: IEventsRepository) : AndroidViewModel(app){

    private val _events: MutableState<List<Event>> = mutableStateOf(listOf())
    val events: MutableState<List<Event>> = _events

    init {
        viewModelScope.launch {
            reloadEvents()
        }
    }

    private suspend fun reloadEvents(){
        repo.fetchEvents()
        _events.value = repo.getHomeEvents()
    }

    fun addEvent(event: Event){
        _events.value = listOf(event) + _events.value
        viewModelScope.launch {
            repo.addEvent(event)
            reloadEvents()
        }
    }

    fun deleteEvent(idx: Int){
        viewModelScope.launch { repo.deleteEvent(_events.value[idx]) }
        if (_events.value.size==1){
            _events.value = listOf()
        }
        else{
            _events.value = _events.value.subList(0,idx) + _events.value.subList(idx+1,_events.value.lastIndex)
        }
        viewModelScope.launch { reloadEvents() }
    }

    fun toggleCompleted(idx: Int){
        _events.value = _events.value.subList(0,idx) + listOf(_events.value[idx].copy(isCompleted = !_events.value[idx].isCompleted)) + _events.value.subList(idx+1,_events.value.lastIndex)
        viewModelScope.launch {
            repo.updateEvent(_events.value[idx])
            reloadEvents()
        }
    }
}