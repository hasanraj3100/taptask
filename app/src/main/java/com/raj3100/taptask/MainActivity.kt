package com.raj3100.taptask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Task>
    lateinit var titleList:Array<String>
    lateinit var priorityList: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.addTaskButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this, AddTask::class.java)
            startActivity(intent)
        }

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

        // add_button functionality


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

