package com.dalamarmajere.sampleretrofit.ui.sample_todo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TodoItem(
    text: String,
    isDone: Boolean,
    onTaskDone: (String, Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            color = Color.DarkGray
        )
        Checkbox(
            checked = isDone,
            onCheckedChange = { onTaskDone(text, it) })
    }
}