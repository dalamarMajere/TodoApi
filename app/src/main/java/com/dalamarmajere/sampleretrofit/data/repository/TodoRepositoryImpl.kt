package com.dalamarmajere.sampleretrofit.data.repository

import com.dalamarmajere.sampleretrofit.TodoApi
import com.dalamarmajere.sampleretrofit.data.TodoItem
import com.dalamarmajere.sampleretrofit.domain.repository.TodoRepository
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val api: TodoApi
): TodoRepository {

    private val TAG = "Retrofit Request Error"

    override suspend fun getTodos(): List<TodoItem> {
        val response = api.getTodos()

        if (response.isSuccessful && response.body() != null) {
            return response.body()!!.map {
                TodoItem(task = it.title, isDone = it.completed)
            }
        }

        return emptyList()
    }

}