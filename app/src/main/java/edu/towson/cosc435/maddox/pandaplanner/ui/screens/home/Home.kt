package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.model.Priority
import edu.towson.cosc435.maddox.pandaplanner.ui.components.EventListView


@ExperimentalFoundationApi
@Composable
fun Home(){
    val vm : HomeViewModel by viewModel()
    val events by vm.events
    val selectedEvent by vm.selectedEvent
    EventListView(
        events,
        selectedEvent,
        onDelete=vm::deleteEvent,
        onToggle=vm::toggleCompleted,
        onSelectEvent=vm::selectEvent,
        onAddEvent={
            val event = Event(eventName = "COSC 435", eventId = 0L, startDate = "2021-21-12", eventDetails = "dummy task", isCompleted = false, endDate = "2021-22-12", priority = Priority.HIGH.toString())
            vm.addEvent(event)
        }
    )
}
