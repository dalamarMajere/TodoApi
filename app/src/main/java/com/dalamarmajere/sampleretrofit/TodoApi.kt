package com.dalamarmajere.sampleretrofit

import com.dalamarmajere.sampleretrofit.domain.dao.TodoDao
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {

    @GET("/todos")
    suspend fun getTodos() : Response<List<TodoDao>>
}