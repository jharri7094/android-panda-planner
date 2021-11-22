package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class HomeViewModel : ViewModel(){
    private val _todos: MutableState<List<Todo>> = mutableStateOf(listOf())
    val todos: State<List<Todo>> = _todos

    private val _selectedTodo: MutableState<Todo>
    val selectedTodo: State<Todo>

    private val _repositoryTodo: ITodosRepository = TodosRepository()

    init{
        _todos.value = _repositoryTodo.getTodos()
        _selectedTodo = mutableStateOf(_todos.value.get(0))
        selectedTodo = _selectedTodo
    }

    fun addTodo(todo: Todo){
        _repositoryTodo.addTodo(todo)
        _todos.value = _repositoryTodo.getTodos()
    }

    fun deleteTodo(idx: Int){
        _repositoryTodo.deleteTodo(idx)
        _todos.value = _repositoryTodo.getTodos()
    }

    fun toggleCompleted(idx: Int){
        _repositoryTodo.toggleCompleted(idx)
        _todos.value = _repositoryTodo.getTodos()
    }

    //fun filterSearch(search: String){}

    fun selectTodo(todo: Todo){
        _selectedTodo.value = todo
    }
}