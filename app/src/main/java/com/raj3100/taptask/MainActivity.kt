package com.raj3100.taptask

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

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Task>
    lateinit var titleList:Array<String>
    lateinit var priorityList: Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleList = arrayOf(
            "Task 1",
            "Task 3",
            "Task 4",
            "Do Homework"
        )

        priorityList = arrayOf(
            2, 0, 1, 2
        )

        recyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<Task>()
        getData()

    }

    private fun getData() {
        for(i in titleList.indices) {
            val dataClass = Task(1, titleList[i], priorityList[i], false)
            dataList.add(dataClass)
            Log.i("raj", "adding $i")

        }

        recyclerView.adapter = Adapter(dataList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }
}

