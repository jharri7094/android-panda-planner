package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

class TodosRepository: ITodosRepository {
    private var _todos: List<Todo>
    private val _originalTodoList: List<Todo>

    init{
        _originalTodoList = (0..3).map { i ->
            Todo("Todo $i", "12am - 12pm", "This is a dummy task",
            false, 3)
        }
        _todos = _originalTodoList.map{ s -> s }
    }

    override fun getTodos(): List<Todo> {
        return _todos
    }
    override fun deleteTodo(idx: Int){
        _todos = _todos.subList(0, idx) + _todos.subList(idx + 1, _todos.size)
    }
    override fun addTodo(todo: Todo){
        _todos = listOf(todo) + _todos
    }
    override fun toggleCompleted(idx: Int){
        val todo = _todos.get(idx)
        val newTodo = todo.copy(isCompleted = !todo.isCompleted)
        val _todos = _todos.subList(0, idx) + listOf(newTodo) +
                _todos.subList(idx + 1, _todos.size)
    }

    //override fun searchFilter(search: String)

}