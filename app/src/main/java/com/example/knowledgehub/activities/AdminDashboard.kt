package com.example.knowledgehub.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.knowledgehub.R

class AdminDashboard : AppCompatActivity() {

    private lateinit var button14 : Button
    private lateinit var button2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        button14 = findViewById(R.id.button14)

        button14.setOnClickListener{
            val intent = Intent(this, AddNewStudent::class.java)
            startActivity(intent)
        }

        button2 = findViewById(R.id.button2)

        button2.setOnClickListener{
            val intent = Intent(this, AddNewRecording::class.java)
            startActivity(intent)
        }
    }
}