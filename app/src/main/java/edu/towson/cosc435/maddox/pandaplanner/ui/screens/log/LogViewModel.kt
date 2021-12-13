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


class LogViewModel(app: Application, private val repo: IEventsRepository) : AndroidViewModel(app){

    private var masterList: List<Event> = listOf()

    private val _listLog : MutableState<List<Event>> = mutableStateOf(listOf())
    val listLog = _listLog

    fun onDelete(idx : Int){
        _listLog.value = masterList.subList(0,idx) + masterList.subList(idx+1,masterList.lastIndex)
        viewModelScope.launch { repo.deleteEvent(masterList[idx]) }
        masterList = _listLog.value
    }

    fun onToggle(idx: Int) {
        _listLog.value = masterList.subList(0,idx) + listOf(masterList[idx].copy(isCompleted = !masterList[idx].isCompleted)) + masterList.subList(idx+1,masterList.lastIndex)
        viewModelScope.launch { repo.updateEvent(masterList[idx]) }
        masterList = _listLog.value
    }

    init{
        viewModelScope.launch {
            masterList = repo.getEvents()
            _listLog.value = masterList
        }
    }
}