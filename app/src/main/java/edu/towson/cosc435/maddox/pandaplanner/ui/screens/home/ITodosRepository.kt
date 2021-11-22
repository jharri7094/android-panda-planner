package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

interface ITodosRepository {
    fun getTodos(): List<Todo>
    fun deleteTodo(idx: Int)
    fun addTodo(todo: Todo)
    fun toggleCompleted(idx: Int)
    //fun searchFilter(search: String)
}