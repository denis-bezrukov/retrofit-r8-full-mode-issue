package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.apiimpl.TestApiLazyImpl2
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Provider
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val api = TestApiLazyImpl2(retrofit())
        CoroutineScope(EmptyCoroutineContext).launch {
            Log.i("r8_full", "Todos: ${api.load()}")
        }
    }

    private fun retrofit(): Provider<Retrofit> = Provider {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        Retrofit.Builder()
            .baseUrl("https://gorest.co.in")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}