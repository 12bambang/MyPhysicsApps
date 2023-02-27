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
import com.example.myphysicsapps.materi.DetailActivityMateri
import com.example.myphysicsapps.materi.Materi
import com.google.gson.Gson

class MateriAdapter(private val listMateri: MateriResponse): RecyclerView.Adapter<MateriAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(viewGroup : ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup
            .context).inflate(R.layout.item_materi,viewGroup,false)
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ListViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener{
            val moveIntent = Intent(viewHolder.itemView.context,DetailActivityMateri::class.java)
            val item = listMateri.data?.get(position)
            val gson = Gson()
            val json = gson.toJson(item)
            moveIntent.putExtra("judul", json)
            viewHolder.itemView.context.startActivity(moveIntent)
        }

        viewHolder.listJudul.text = listMateri.data?.get(position)?.attributes?.title
        viewHolder.preview.text = listMateri.data?.get(position)?.attributes?.analogy

        Glide.with(viewHolder.materiPic.context)
            .load("http://192.168.89.8:1337"+ (listMateri.data?.get(position)?.attributes?.profilePic?.data?.attributes?.url))
            .into(viewHolder.materiPic)

        //viewHolder.videoView.setVideoPath("http://192.168.167.66:1337"+ (listMateri.data?.get(position)?.attributes?.profilePic?.data?.attributes?.url))
        //viewHolder.videoView.start()
    }

    override fun getItemCount() = listMateri.data!!.size

    class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val listJudul: TextView = view.findViewById(R.id.listJudul)
        val materiPic: ImageView = view.findViewById(R.id.materiPic)
        val preview: TextView = view.findViewById(R.id.preview)

    }

}