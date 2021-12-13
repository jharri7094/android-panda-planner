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

    private var masterList: List<Event> = listOf()
    private val _events: MutableState<List<Event>> = mutableStateOf(listOf())
    val events: State<List<Event>> = _events

    init {
        viewModelScope.launch {
            masterList = repo.getEvents()
            _events.value = masterList.filter { event -> !event.isCompleted }
        }
    }

    fun addEvent(event: Event){
        _events.value = listOf(event) + masterList
        viewModelScope.launch {
            repo.addEvent(event)
        }
    }

    fun deleteEvent(idx: Int){
        _events.value = masterList.subList(0,idx) + masterList.subList(idx+1,masterList.lastIndex)
        viewModelScope.launch { repo.deleteEvent(masterList[idx]) }
        masterList = _events.value
    }

    fun toggleCompleted(idx: Int){
        _events.value = masterList.subList(0,idx) + listOf(masterList[idx].copy(isCompleted = !masterList[idx].isCompleted)) + masterList.subList(idx+1,masterList.lastIndex)
        viewModelScope.launch {
            repo.updateEvent(masterList[idx])
        }
        masterList = _events.value
    }
}