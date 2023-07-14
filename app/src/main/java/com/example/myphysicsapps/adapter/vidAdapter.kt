package com.example.myphysicsapps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myphysicsapps.MateriResponse
import com.example.myphysicsapps.R
import com.example.myphysicsapps.video.DetailVideoActivity
import com.example.myphysicsapps.video.vidfisika
import com.google.gson.Gson

class vidAdapter(private val listvideo: MateriResponse): RecyclerView.Adapter<vidAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup : ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_video, viewGroup, false))



//    override fun onBindViewHolder(viewHolder: ListViewHolder, position: Int) {
//        viewHolder.itemView.setOnClickListener{
//            val moveIntent = Intent(viewHolder.itemView.context,DetailVideoActivity::class.java)
//            val item = listvideo.data?.get(position)
//            val gson = Gson()
//            val json = gson.toJson(item)
//            moveIntent.putExtra("judul", json)
//            viewHolder.itemView.context.startActivity(moveIntent)
//        }
//
//        viewHolder.listJudul.text = listvideo.data?.get(position)?.attributes?.title
//
//        Glide.with(viewHolder.materiPic.context)
//            .load("http://192.168.211.8:1337"+ (listvideo.data?.get(position)?.attributes?.profilePic?.data?.attributes?.url))
//            .into(viewHolder.materiPic)
//
//        //viewHolder.videoView.setVideoPath("http://192.168.167.66:1337"+ (listMateri.data?.get(position)?.attributes?.profilePic?.data?.attributes?.url))
//        //viewHolder.videoView.start()
//    }

    override fun getItemCount() = listvideo.data!!.size

//    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//
////        val preview: TextView = view.findViewById(R.id.preview)
//
//    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val listJudul: TextView = view.findViewById(R.id.listJudulVideo)
        val materiPic: ImageView = view.findViewById(R.id.materiPicVideo)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener{
            val moveIntent = Intent(viewHolder.itemView.context,DetailVideoActivity::class.java)
            val item = listvideo.data?.get(position)
            val gson = Gson()
            val json = gson.toJson(item)
            moveIntent.putExtra("judul", json)
            viewHolder.itemView.context.startActivity(moveIntent)
        }

        viewHolder.listJudul.text = listvideo.data?.get(position)?.attributes?.title

        Glide.with(viewHolder.materiPic.context)
            .load("http://192.168.24.8:1337"+ (listvideo.data?.get(position)?.attributes?.profilePic?.data?.attributes?.url))
            .into(viewHolder.materiPic)

        //viewHolder.videoView.setVideoPath("http://192.168.167.66:1337"+ (listMateri.data?.get(position)?.attributes?.profilePic?.data?.attributes?.url))
        //viewHolder.videoView.start()
    }
}