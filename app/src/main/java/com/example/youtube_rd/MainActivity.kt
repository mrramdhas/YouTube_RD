package com.example.youtube_rd

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.setBackgroundColor(Color.WHITE)
        recyclerView_main.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?

        fetchJson()

    }

    fun fetchJson () {
        val urlString = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val request  = Request.Builder().url(urlString).build()

        var client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                    println("failed")
            }

            override fun onResponse(call: Call, response: Response) {
                val response = response.body()?.string()
                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(response, HomeFeed::class.java)
                runOnUiThread {
                    recyclerView_main.adapter = Main_Adapter(homeFeed)
                }
            }
        })
    }
}
