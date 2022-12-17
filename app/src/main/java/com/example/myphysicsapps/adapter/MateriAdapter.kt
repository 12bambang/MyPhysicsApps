package com.example.myphysicsapps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myphysicsapps.R
import com.example.myphysicsapps.materi.DetailActivityMateri
import com.example.myphysicsapps.materi.Materi

class MateriAdapter(private val listMateri: ArrayList<Materi>): RecyclerView.Adapter<MateriAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(viewGroup : ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup
            .context).inflate(R.layout.item_materi,viewGroup,false)
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ListViewHolder, position: Int) {
        val (judul,foto,analogy,rumus,penjelasan) = listMateri[position]

        viewHolder.listJudul.text = judul
        viewHolder.preview.text = analogy
        Glide.with(viewHolder.materiPic.context)
            .load(listMateri[position].foto)
            .into(viewHolder.materiPic)

        viewHolder.itemView.setOnClickListener {
            val moveIntent = Intent(viewHolder.itemView.context, DetailActivityMateri::class.java).putExtra("parcelable",listMateri[position])
            viewHolder.itemView.context.startActivity(moveIntent)
        }

    }

    override fun getItemCount() = listMateri.size

    class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val listJudul: TextView = view.findViewById(R.id.listJudul)
        val materiPic: ImageView = view.findViewById(R.id.materiPic)
        val preview: TextView = view.findViewById(R.id.preview)

    }



}