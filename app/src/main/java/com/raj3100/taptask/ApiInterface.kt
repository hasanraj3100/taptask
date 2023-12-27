package com.raj3100.taptask

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/apifile.php?userID=1")
    fun getData(): Call<List<Task>>
}