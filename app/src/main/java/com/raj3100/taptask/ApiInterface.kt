package com.raj3100.taptask

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("/~gadhacom/api/getTasks.php?userID=1")
    fun getData(): Call<List<Task>>


    @FormUrlEncoded
    @POST("/~gadhacom/api/saveTask.php")
    fun saveTask(
        @Field("title") title:String,
        @Field("priority") priority:Int,
        @Field("userID") userID:String
    ) : Call<Task>


    @FormUrlEncoded
    @POST("/~gadhacom/api/updateTask.php")
    fun updatetask (
        @Field("id") id:Int,
        @Field("isFinished") isFinished:Int
    ): Call<Task>


    @FormUrlEncoded
    @POST("/~gadhacom/api/deleteTask.php")
    fun deleteTask(
        @Field("id") id:Int
    ): Call<Task>
}