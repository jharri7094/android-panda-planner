package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.model.Priority
import edu.towson.cosc435.maddox.pandaplanner.ui.components.EventListView
import edu.towson.cosc435.maddox.pandaplanner.ui.components.GenericText
import edu.towson.cosc435.maddox.pandaplanner.ui.components.Header


@ExperimentalFoundationApi
@Composable
fun Home(vm : HomeViewModel,
        onFabClick : ()->Unit){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Header(text = "Active Events")
        if (vm.events.value.isNotEmpty())
        EventListView(
            vm.events.value,
            onDelete=vm::deleteEvent,
            onToggle=vm::toggleCompleted,
            onAddEvent={ onFabClick() },
            isFabVisible = true
        )
        else {
            GenericText(Text = "No active events to display", fontWeight = FontWeight.W700)
        }
    }

}
