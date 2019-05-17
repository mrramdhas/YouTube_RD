package com.example.youtube_rd

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class Main_Adapter(var feed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return feed.videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewGroup: Int): CustomViewHolder {
        val customInflater = LayoutInflater.from(parent.context)
        var row = customInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(row)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = feed.videos.get(position)
        holder.view.videlTitle.text = video.name
        holder.view.channelName.text = video.channel.name + " • " + "14k Views" + " • " + "2 Days ago"
        val coverImageView = holder?.view?.VideoCoverImage
        Picasso.get().load(video.imageUrl).into(coverImageView)
        Picasso.get().load(video.channel.profileImageUrl).into(holder.view.authorThumbnail)
    }

}

class CustomViewHolder(val view : View) : RecyclerView.ViewHolder (view) {

}