package com.example.youtube_rd

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.course_list.*

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_list)
        course_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        course_list.adapter = CourseDetailAdapter()
    }

    private class CourseDetailAdapter: RecyclerView.Adapter<CourseDetailViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailViewHolder {

            val customInflater = LayoutInflater.from(parent.context)
            var row = customInflater.inflate(R.layout.course_row, parent, false)
            return CourseDetailViewHolder(row)
        }

        override fun getItemCount(): Int {
            return 1
        }

        override fun onBindViewHolder(viewHolder: CourseDetailViewHolder, position: Int) {

        }

    }

    private class CourseDetailViewHolder(val customView: View): RecyclerView.ViewHolder(customView) {

    }

}