package com.dalamarmajere.sampleretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.dalamarmajere.sampleretrofit.ui.TodoListViewModel
import com.dalamarmajere.sampleretrofit.ui.sample_todo.TodoList
import com.dalamarmajere.sampleretrofit.ui.theme.SampleRetrofitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleRetrofitTheme {
                val viewModel: TodoListViewModel = hiltViewModel()

                val state by viewModel.state.collectAsState()

                TodoList(state = state, onTaskDone = viewModel::onTaskDone)
            }
        }
    }
}