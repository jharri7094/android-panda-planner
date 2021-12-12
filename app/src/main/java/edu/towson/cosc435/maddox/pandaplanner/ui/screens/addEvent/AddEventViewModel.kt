package edu.towson.cosc435.maddox.pandaplanner.ui.screens.addEvent

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import edu.towson.cosc435.maddox.pandaplanner.model.Event

class AddEventViewModel : ViewModel(){

    private val _startDate: MutableState<String> = mutableStateOf("")
    val startDate: State<String> = _startDate
    private val _endDate: MutableState<String> = mutableStateOf("")
    val endDate: State<String> = _endDate
    private val _eventName: MutableState<String> = mutableStateOf("")
    val eventName: State<String> = _eventName
    private val _eventDetails: MutableState<String> = mutableStateOf("")
    val eventDetails: State<String> = _eventDetails
    private val _priority: MutableState<String> = mutableStateOf("")
    val priority: State<String> = _priority
    private val _isCompleted: MutableState<Boolean> = mutableStateOf(false)
    val isCompleted: State<Boolean> = _isCompleted

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
        _priority.value = priority
    }

    fun setIsCompleted(isCompleted: Boolean) {
        _isCompleted.value = isCompleted
    }

    /**
     * Validate the input fields and will throw an exception if not valid.
     * Otherwise, a valid Song object is returned
     */
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
        return Event(eventId = 0L, startDate = startDate.value, endDate = endDate.value, eventName = eventName.value, eventDetails = eventDetails.value, priority = priority.value, isCompleted = isCompleted.value)
    }
}