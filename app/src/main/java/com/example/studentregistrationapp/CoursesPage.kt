package com.example.studentregistrationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_page)
        display()
    }
    fun display() {
        var rvCourses = findViewById<RecyclerView>(R.id.rvCourses)
        var listofCourses = listOf(
            Courses(
                "IOT",
                "12345",
                "Barre Yassin",
                "Where hardware meets Software. Connecting devices through bleh bleh"
            ),
            Courses(
                "Python",
                "12345",
                "Barre Yassin",
                "Where hardware meets Software. Connecting devices through bleh bleh"
            ),

            Courses(
                "Javcript",
                "12345",
                "Barre Yassin",
                "Where hardware meets Software. Connecting devices through bleh bleh"
            ),

            Courses(
                "FrontEnd Mobile Dev",
                "12345",
                "Barre Yassin",
                "Where hardware meets Software. Connecting devices through bleh bleh"
            ),

            Courses(
                "NYJ",
                "12345",
                "Barre Yassin",
                "Where hardware meets Software. Connecting devices through bleh bleh"
            ),

            Courses(
                "Professional development",
                "12345",
                "Barre Yassin",
                "Where hardware meets Software. Connecting devices through bleh bleh"
            ),

            Courses(
                "UX Research",
                "12345",
                "Barre Yassin",
                "Where hardware meets Software. Connecting devices through bleh bleh"
            ),

            Courses(
                "UI Design",
                "12345",
                "Barre Yassin",
                "Where hardware meets Software. Connecting devices through bleh bleh"
            )
        )
        var makecourseadapter = CoursesAdapter(listofCourses)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=makecourseadapter
    }

}