package com.example.mycountryapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MyClass {

    fun titleCase(text: String): String {
        if (text.isEmpty()) return text
        return text[0].uppercase() + text.substring(1).lowercase()
    }


    fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("MMM dd, HH:mm:ss ZZZZ", Locale.getDefault())
        return sdf.format(Date())
    }


    object RetrofitInstance{
        private const val BASE_URL ="http://api.openweathermap.org/data/2.5/"
        private const val apiKey1 ="7e4738b57d7e297ea13a44745bcf433d"
        private const val apiKey2 ="9e9777e62b200d7ccb120f3d1ab79f9b"



    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService: ApiService = retrofit.create(ApiService::class.java)


    interface ApiService {
        @get:GET("users")
        val users: Call<List<User?>?>?
    }
}







