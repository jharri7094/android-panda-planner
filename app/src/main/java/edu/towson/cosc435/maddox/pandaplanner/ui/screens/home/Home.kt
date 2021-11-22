package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.cosc435.maddox.pandaplanner.model.Event


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
            val event = Event("COSC 435", "12pm - 12am", "dummy task", false, 3)
            vm.addEvent(event)
        }
    )
}
