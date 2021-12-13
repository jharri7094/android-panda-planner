package edu.towson.cosc435.maddox.pandaplanner.ui.screens.log

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.maddox.pandaplanner.data.IEventsRepository
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import kotlinx.coroutines.launch


class LogViewModel(app: Application, private val repo: IEventsRepository) : AndroidViewModel(app){

    private val _listLog : MutableState<List<Event>> = mutableStateOf(listOf())
    val listLog = _listLog

    fun onDelete(idx : Int){
        viewModelScope.launch { repo.deleteEvent(_listLog.value[idx]) }
        _listLog.value = _listLog.value.subList(0,idx) + _listLog.value.subList(idx+1,_listLog.value.lastIndex)
        viewModelScope.launch {
            reloadEvents()
        }
    }

    fun onToggle(idx: Int) {
        _listLog.value = _listLog.value.subList(0,idx) + listOf(_listLog.value[idx].copy(isCompleted = !_listLog.value[idx].isCompleted)) + _listLog.value.subList(idx+1,_listLog.value.lastIndex)
        viewModelScope.launch { repo.updateEvent(_listLog.value[idx])
        reloadEvents()}
    }
    private suspend fun reloadEvents(){
        repo.fetchEvents()
        _listLog.value = repo.getAllEvents()
    }


    init{
        viewModelScope.launch {
            reloadEvents()
        }
    }
}