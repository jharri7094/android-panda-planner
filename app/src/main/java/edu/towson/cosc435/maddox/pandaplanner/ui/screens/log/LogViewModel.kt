package edu.towson.cosc435.maddox.pandaplanner.ui.screens.log

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository
import edu.towson.cosc435.maddox.pandaplanner.data.IEventsRepository
import edu.towson.cosc435.maddox.pandaplanner.model.Event


class LogViewModel(app: Application) : AndroidViewModel(app){

    private val _listLog : MutableState<List<Event>> = mutableStateOf(listOf())
    val listLog: State<List<Event>> = _listLog

    private val _repositoryEvent: IEventsRepository = EventsRepository(app)

    init{
        _listLog.value = _repositoryEvent.getDummyEvents()
    }
}