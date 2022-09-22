package com.example.myapplication.apis

import retrofit2.http.GET

interface TestApi {
    @GET("/public/v2/todos")
    suspend fun load(): List<ToDoModel>
}

interface TestApi2 : TestApi