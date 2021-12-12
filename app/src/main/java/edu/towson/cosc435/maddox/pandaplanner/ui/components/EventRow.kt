package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.towson.cosc435.maddox.pandaplanner.model.Event

@ExperimentalFoundationApi
@Composable
fun EventRow(
    index: Int,
    event: Event,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .combinedClickable(
                    onLongClick = {
                        onDelete(index)
                    },
                    onClick = { onToggle(index) }
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(event.endDate, modifier = Modifier.weight(3.0f), fontSize = 32.sp)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(event.startDate, modifier = Modifier.weight(2.0f), fontSize = 28.sp)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(event.eventName, modifier = Modifier.weight(2.0f))
                }
            }
            Column(
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(checked = false, onCheckedChange = { onToggle(index) }, modifier = Modifier.padding(end=5.dp))
                }
            }
        }
    }
}