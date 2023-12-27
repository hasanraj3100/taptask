package com.raj3100.taptask

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.ComponentActivity
import com.raj3100.taptask.R

class AddTask : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val spinner = findViewById<Spinner>(R.id.spinnder)
        val arr = arrayOf("Priority: Low", "Priority: Medium", "Priority: High")
        val adpt = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr)
        spinner.adapter = adpt
    }
}