package com.dalamarmajere.sampleretrofit.di

import com.dalamarmajere.sampleretrofit.TodoApi
import com.dalamarmajere.sampleretrofit.data.repository.TodoRepositoryImpl
import com.dalamarmajere.sampleretrofit.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoApi(): TodoApi = RetrofitInstance.api

    @Provides
    @Singleton
    fun provideRepository(api: TodoApi): TodoRepository = TodoRepositoryImpl(api)

}