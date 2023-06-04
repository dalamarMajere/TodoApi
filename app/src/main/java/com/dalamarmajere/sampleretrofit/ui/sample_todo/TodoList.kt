package com.dalamarmajere.sampleretrofit.ui.sample_todo

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dalamarmajere.sampleretrofit.ui.TodoListState

@Composable
fun TodoList(
    state: TodoListState,
    onTaskDone: (String, Boolean) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(state.todoItems) {
            TodoItem(text = it.task, isDone = it.isDone, onTaskDone = onTaskDone)
        }
    }
}