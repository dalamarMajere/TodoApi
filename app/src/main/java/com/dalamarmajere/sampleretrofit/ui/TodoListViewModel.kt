package com.dalamarmajere.sampleretrofit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dalamarmajere.sampleretrofit.data.TodoItem
import com.dalamarmajere.sampleretrofit.domain.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(TodoListState())

    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), TodoListState())

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {
            _state.update { it.copy(
                todoItems = repository.getTodos()
            ) }
        }
    }

    fun onTaskDone(task: String, isDone: Boolean) {
        _state.update { it.copy(
            todoItems = it.todoItems.map { todoItem ->
                if (task == todoItem.task) {
                    TodoItem(task = todoItem.task, isDone = isDone)
                }
                else {
                    todoItem
                }
            }
        ) }
    }
}