package com.example.youtube_rd

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.video_row.view.*

class Main_Adapter: RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewGroup: Int): CustomViewHolder {
        val customInflater = LayoutInflater.from(parent.context)
        var row = customInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(row)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.videlTitle.text = "Test"
    }

}

class CustomViewHolder(val view : View) : RecyclerView.ViewHolder (view) {

}