package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@ExperimentalFoundationApi
@Composable
fun TodoListView(
    todos: List<Todo>,
    selectedTodo: Todo,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit,
    //onFilter: (String) -> Unit,
    onSelectTodo: (Todo) -> Unit,
    onAddTodo: () -> Unit
){
    Box(
        contentAlignment = Alignment.Center
    )
        {
          Column(){
              LazyColumn{
                  itemsIndexed(todos) { index, todo ->
                      TodoRow(index, todo, onDelete, onToggle, onSelectTodo)

                  }
              }
          }
            AddTodoFloatingActionButton(
                onClick = onAddTodo,
                modifier = Modifier.padding(12.dp).align(Alignment.BottomEnd)
            )
        }
}