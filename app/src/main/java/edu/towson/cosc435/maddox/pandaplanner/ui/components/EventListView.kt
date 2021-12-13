package edu.towson.cosc435.maddox.pandaplanner.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.EventRow


@ExperimentalFoundationApi
@Composable
fun EventListView(
    events: List<Event>,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit,
    onAddEvent: () -> Unit,
    isFabVisible : Boolean
){
    Box(
        contentAlignment = Alignment.Center
    )
        {
          Column {
              LazyColumn{
                  itemsIndexed(events) { index, event ->
                      EventRow(index, event, onDelete, onToggle)

                  }
              }
          }
            if (isFabVisible) {
                AddEventFAB(
                    onClick = onAddEvent,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
}