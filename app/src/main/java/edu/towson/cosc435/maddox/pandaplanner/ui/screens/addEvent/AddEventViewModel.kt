package edu.towson.cosc435.maddox.pandaplanner.ui.screens.addEvent

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository
import edu.towson.cosc435.maddox.pandaplanner.data.IEventsRepository
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.model.Priority
import kotlinx.coroutines.launch

class AddEventViewModel(app : Application) : AndroidViewModel(app){


    private val _startDate: MutableState<String> = mutableStateOf("")
    val startDate: State<String> = _startDate

    private val _endDate: MutableState<String> = mutableStateOf("")
    val endDate: State<String> = _endDate

    private val _eventName: MutableState<String> = mutableStateOf("")
    val eventName: State<String> = _eventName

    private val _eventDetails: MutableState<String> = mutableStateOf("")
    val eventDetails: State<String> = _eventDetails

    private val _isCompleted: MutableState<Boolean> = mutableStateOf(false)
    val isCompleted: State<Boolean> = _isCompleted

    private val _showValidationErrorDialog : MutableState<Boolean> = mutableStateOf(false)
    val showValidationErrorDialog = _showValidationErrorDialog

    private val _selectedPriority: MutableState<Priority> = mutableStateOf(Priority.LOW)
    val selectedPriority = _selectedPriority

    fun setStartDate(startDate: String) {
        _startDate.value = startDate
    }

    fun setEndDate(endDate: String) {
        _endDate.value = endDate
    }

    fun setEventName(eventName: String) {
        _eventName.value = eventName
    }

    fun setEventDetails(eventDetails: String) {
        _eventDetails.value = eventDetails
    }

    fun setPriority(priority: String) {
        when (priority){
            "High"->_selectedPriority.value = Priority.HIGH
            "Medium"->_selectedPriority.value = Priority.MEDIUM
            "Low"->_selectedPriority.value = Priority.LOW
        }
    }

    fun setIsCompleted(isCompleted: Boolean) {
        _isCompleted.value = isCompleted
    }

    fun validate(): Event {
        if(startDate.value.isEmpty()) {
            throw Exception("Start date is needed")
        }
        if(endDate.value.isEmpty()) {
            throw Exception("End date is needed")
        }
        if(eventName.value.isEmpty()) {
            throw Exception("Event name is needed")
        }
        return Event(eventId = 0L, startDate = startDate.value, endDate = endDate.value, eventName = eventName.value, eventDetails = eventDetails.value, priority = selectedPriority.value.toString(), isCompleted = isCompleted.value)
    }

    fun toggleShowValidationErrorDialog() {
        _showValidationErrorDialog.value = !_showValidationErrorDialog.value
    }
}