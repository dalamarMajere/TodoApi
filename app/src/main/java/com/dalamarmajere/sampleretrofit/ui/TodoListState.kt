package com.dalamarmajere.sampleretrofit.ui

import com.dalamarmajere.sampleretrofit.data.TodoItem

data class TodoListState(
    val todoItems: List<TodoItem> = emptyList()
)