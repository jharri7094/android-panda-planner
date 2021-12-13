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
fun Home(vm : HomeViewModel,
        onFabClick : ()->Unit){
    val events by vm.events
    EventListView(
        events,
        onDelete=vm::deleteEvent,
        onToggle=vm::toggleCompleted,
        onAddEvent={ onFabClick() },
        isFabVisible = true
    )
}
