package com.dalamarmajere.sampleretrofit.domain.dao

data class TodoDao(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)