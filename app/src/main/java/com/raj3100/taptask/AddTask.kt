package com.raj3100.taptask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.raj3100.taptask.R
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTask : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val spinner = findViewById<Spinner>(R.id.spinnder)
        val arr = arrayOf("Priority: Low", "Priority: Medium", "Priority: High")
        val adpt = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr)
        spinner.adapter = adpt

        val addBtn = findViewById<Button>(R.id.add_button)
        val titleText = findViewById<EditText>(R.id.create_title)


        addBtn.setOnClickListener {
            val editor = getSharedPreferences("user_data", MODE_PRIVATE)
            val userName = editor.getString("userID", null);
            val title = titleText.text.toString()
            val priorityText = spinner.selectedItem.toString()
            var priority =0
            if(priorityText == arr[0]) priority =0
            else if(priorityText == arr[1]) priority =1
            else priority = 2
            val t = Task(6, "Hello", 2, 0)
            Log.i("thik info", "$title, $priority, $userName")
            if (userName != null) {
                 RetrofitInstance.apiInterface.saveTask(title, priority, userName).enqueue(object : Callback<Task?> {
                     override fun onResponse(call: Call<Task?>, response: Response<Task?>) {


                     }

                     override fun onFailure(call: Call<Task?>, t: Throwable) {

                     }
                 })

            }


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()


        }
    }
}