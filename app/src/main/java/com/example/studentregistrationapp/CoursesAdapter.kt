package com.example.studentregistrationapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter(var courses:List<Courses>):RecyclerView.Adapter<CoursesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemview=LayoutInflater.from(parent.context).inflate(R.layout.course_list_item,parent,false)
        return CoursesViewHolder(itemview)

    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        var currentcourse=courses.get(position)
        holder.tvcourseName.text=currentcourse.courseName
        holder.tvcourseid.text=currentcourse.coursecode
        holder.tvcoursedescription.text=currentcourse.description
        holder.tvinstructor.text=currentcourse.instructor
    }

    override fun getItemCount(): Int {
        return courses.size
    }
}
class CoursesViewHolder(var itemView:View):RecyclerView.ViewHolder(itemView){
    var tvcourseName=itemView.findViewById<TextView>(R.id.tvcoursename)
    var tvcourseid=itemView.findViewById<TextView>(R.id.tvcourseid)
    var tvcoursedescription=itemView.findViewById<TextView>(R.id.tvdescription)
    var tvinstructor=itemView.findViewById<TextView>(R.id.tvInstructor)
}