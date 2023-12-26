package com.raj3100.taptask

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity

class AddTask : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_task)
    }
}