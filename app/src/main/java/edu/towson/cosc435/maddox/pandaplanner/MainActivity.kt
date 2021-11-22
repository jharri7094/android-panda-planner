package edu.towson.cosc435.maddox.pandaplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.HomeViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.Todo
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.TodoListView
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.PandaPlannerTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PandaPlannerTheme {
                    val vm: HomeViewModel by viewModels()
                    val todos by vm.todos
                    val selectedTodo by vm.selectedTodo
                    TodoListView(
                        todos,
                        selectedTodo,
                        onDelete=vm::deleteTodo,
                        onToggle=vm::toggleCompleted,
                        //onFilter=vm::filter,
                        onSelectTodo=vm::selectTodo,
                        onAddTodo={
                            val todo = Todo("COSC 435", "12pm - 12am", "dummy task", false, 3)
                            vm.addTodo(todo)
                        }
                    )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PandaPlannerTheme {
        Greeting("Android")
    }
}