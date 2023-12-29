package com.raj3100.taptask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("http://172.104.62.106/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}