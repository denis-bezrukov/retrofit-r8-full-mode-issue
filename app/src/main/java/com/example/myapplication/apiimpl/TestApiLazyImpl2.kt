package com.example.myapplication.apiimpl

import com.example.myapplication.apis.TestApi2
import retrofit2.Retrofit
import javax.inject.Provider

public class TestApiLazyImpl2(retrofit: Provider<Retrofit>) : TestApi2 {
    private val deferred = retrofit.get().create(TestApi2::class.java)

    public override suspend fun load() = deferred.load()
}