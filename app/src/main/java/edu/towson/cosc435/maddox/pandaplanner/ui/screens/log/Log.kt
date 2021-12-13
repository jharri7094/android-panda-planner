package edu.towson.cosc435.maddox.pandaplanner.ui.screens.log

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import edu.towson.cosc435.maddox.pandaplanner.ui.components.GenericText
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.EventRow

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun loadList(
    vm: LogViewModel,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit
) {
    if (vm.listLog.value.isNotEmpty()) {
        LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
        ) {

            itemsIndexed(vm.listLog.value) { idx, event ->
                EventRow(idx, event, onDelete = onDelete, onToggle = onToggle)
            }
        }
    }
    else
    GenericText(Text = "No events to list")
}