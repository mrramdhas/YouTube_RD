package com.example.youtube_rd

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.youtube_rd.CustomViewHolder.Companion.VIDEO_ID_KEY
import com.example.youtube_rd.CustomViewHolder.Companion.VIDEO_TITLE_KEY
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.course_list.*
import okhttp3.*
import java.io.IOException

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_list)
        course_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        course_list.adapter = CourseDetailAdapter()
        var videoTitle = intent.getStringExtra(VIDEO_TITLE_KEY)
        supportActionBar?.title = videoTitle
        fetchJson()
    }

    private fun fetchJson() {
        val videoID = intent.getIntArrayExtra(VIDEO_ID_KEY)
        val courseDetailURL = "https://api.letsbuildthatapp.com/youtube/course_detail?id=" + videoID

        val client = OkHttpClient()
        val urlReq = Request.Builder().url(courseDetailURL).build()
        client.newCall(urlReq).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()
                val courseDetail = gson.fromJson(body, CourseLession::class.java)
            }

        })
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