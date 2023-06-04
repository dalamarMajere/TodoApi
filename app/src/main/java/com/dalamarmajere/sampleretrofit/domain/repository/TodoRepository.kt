package com.dalamarmajere.sampleretrofit.domain.repository

import com.dalamarmajere.sampleretrofit.TodoApi
import com.dalamarmajere.sampleretrofit.data.TodoItem
import javax.inject.Inject

interface TodoRepository{
    suspend fun getTodos() : List<TodoItem>
}