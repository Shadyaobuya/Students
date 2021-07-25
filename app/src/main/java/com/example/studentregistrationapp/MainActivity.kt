package com.example.studentregistrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var admin =findViewById<Button>(R.id.btnAdmin)
        var student=findViewById<Button>(R.id.btnStudent)
        student.setOnClickListener {
            var intent=Intent(baseContext,StudentRegistration::class.java)
                startActivity(intent)
        }
        admin.setOnClickListener {

            var intent=Intent(baseContext,AdminPage::class.java)
            startActivity(intent)
        }
    }
}