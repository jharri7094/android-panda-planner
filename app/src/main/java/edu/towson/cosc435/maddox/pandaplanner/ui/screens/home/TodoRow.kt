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
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*

@ExperimentalFoundationApi
@Composable
fun TodoRow(
    index: Int,
    todo: Todo,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit,
    onSelectedTodo: (Todo) -> Unit
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 16.dp,
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 7.dp, bottom = 7.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .combinedClickable(
                    onLongClick = {
                        onToggle(index)
                    },
                    onClick = { onSelectedTodo(todo) }
                )
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.weight(1.5f)
            ) {
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(todo.timePeriod, modifier = Modifier.weight(3.0f), fontSize = 32.sp)
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(todo.name, modifier = Modifier.weight(2.0f), fontSize = 28.sp)
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(todo.details, modifier = Modifier.weight(2.0f))
                }
            }
            Column(
                modifier = Modifier.weight(1.0f)
            ) {
/*                Button(onClick= { onDelete(index) }, modifier = Modifier.fillMaxWidth()) {
                    Text("Delete")
                }*/
                Spacer(modifier = Modifier.padding(bottom = 5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(checked = todo.isCompleted, onCheckedChange = { onToggle(index) }, modifier = Modifier.padding(end=5.dp))
                }
            }
        }
    }
}