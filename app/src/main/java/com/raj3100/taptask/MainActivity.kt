package com.raj3100.taptask

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Task>
   var titleList:ArrayList<String> = ArrayList<String>()
    var priorityList: ArrayList<Int> = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonClick = findViewById<Button>(R.id.addTaskButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this, AddTask::class.java)
            startActivity(intent)
        }

//        titleList = arrayOf(
//            "Task 1",
//            "Task 3",
//            "Task 4",
//            "Do Homework"
//        )

//        priorityList = arrayOf(
//            2, 0, 1, 2
//        )

        recyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<Task>()

        getDataFromServer()

    }

    private fun getData() {
        for(i in titleList.indices) {
            val dataClass = Task(1, titleList[i], priorityList[i], 0)
            dataList.add(dataClass)


        }

        recyclerView.adapter = Adapter(dataList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onMenuItemSelected(featureId: Int, item: MenuItem): Boolean {

        val id:Int = item.itemId

        if(id == R.id.about) {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        return super.onMenuItemSelected(featureId, item)
    }


    private fun getDataFromServer() {
        val progresDialog = ProgressDialog(this)
        progresDialog.setMessage("Please wait while data is being fetched")
        progresDialog.show()

        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<List<Task>?> {
            override fun onResponse(call: Call<List<Task>?>, response: Response<List<Task>?>) {
                Log.i("thik", response.body()?.size.toString())
                val responseData: List<Task>? = response.body()
                val titles:Array<String> ;
                if (responseData != null) {
                    for (item in responseData) {
                       titleList.add(item.title.toString())
                        priorityList.add(item.priority.toInt())
                    }
                }
                progresDialog.dismiss()
                getData()
            }

            override fun onFailure(call: Call<List<Task>?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_LONG).show()
                progresDialog.dismiss()
            }
        })
    }



}

