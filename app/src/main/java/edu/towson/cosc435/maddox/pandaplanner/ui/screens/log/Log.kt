package edu.towson.cosc435.maddox.pandaplanner.ui.screens.log

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.addEvent.AddEventViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.EventRow

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun loadList(
    vm: LogViewModel = viewModel(),
    listLog: State<List<Event>> =  vm.listLog,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        itemsIndexed(listLog.value){ idx, event->
            EventRow(idx, event, onDelete = onDelete, onToggle = onToggle)
        }
    }
}