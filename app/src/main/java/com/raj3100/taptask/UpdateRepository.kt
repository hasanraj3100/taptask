package com.raj3100.taptask

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateRepository {

    companion object {
        fun updateTheTask(id:Int, isFinished:Int) {
            RetrofitInstance.apiInterface.updatetask(id, isFinished).enqueue(object : Callback<Task?> {
                override fun onResponse(call: Call<Task?>, response: Response<Task?>) {

                }

                override fun onFailure(call: Call<Task?>, t: Throwable) {

                }
            })
            Log.i("thik", "WOrks yeay")
        }

        fun deleteTheTask(id: Int) {
            RetrofitInstance.apiInterface.deleteTask(id).enqueue(object : Callback<Task?> {
                override fun onResponse(call: Call<Task?>, response: Response<Task?>) {

                }

                override fun onFailure(call: Call<Task?>, t: Throwable) {

                }
            })
        }
    }

}