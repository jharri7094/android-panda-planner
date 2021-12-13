package edu.towson.cosc435.maddox.pandaplanner.ui.screens.log

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


class LogViewModel(app: Application) : AndroidViewModel(app){

    private var eventList = listOf<Event>()

    private val _listLog : MutableState<List<Event>> = mutableStateOf(listOf())
    val listLog = _listLog

    private val repo: IEventsRepository = EventsRepository(app)

    fun onDelete(idx : Int){
        _listLog.value = _listLog.value.subList(0,idx) + _listLog.value.subList(idx+1,_listLog.value.lastIndex)
        viewModelScope.launch { repo.deleteEvent(_listLog.value[idx]) }
    }

    fun onToggle(idx: Int) {
        _listLog.value = _listLog.value.subList(0,idx) + _listLog.value[idx].copy(isCompleted = !_listLog.value[idx].isCompleted)+ _listLog.value.subList(idx+1,_listLog.value.lastIndex)
        viewModelScope.launch { repo.updateEvent(_listLog.value[idx]) }
    }

    init{
        viewModelScope.launch {
            _listLog.value = repo.getEvents()
            eventList = repo.getEvents()
        }
    }
}