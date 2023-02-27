package com.example.myphysicsapps.materi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import com.bumptech.glide.Glide
import com.example.myphysicsapps.DataItem
import com.example.myphysicsapps.R
import com.google.gson.Gson

class DetailActivityMateri : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_materi)

        supportActionBar?.hide()

        val gson = Gson()

        val judul = intent.getStringExtra("judul")
        val obj : DataItem = gson.fromJson(judul, DataItem::class.java)

        val profildetail : ImageView= this.findViewById(R.id.profildetail)
        val juduldetail : TextView = this.findViewById(R.id.juduldetail)
        val analogy : TextView = this.findViewById(R.id.analogi)
        val animasi : VideoView = this.findViewById(R.id.otrvideo)
        val isimateri : TextView = this.findViewById(R.id.isiMateri)

        juduldetail.text = obj.attributes?.title
        Glide.with(this).load("http://192.168.89.8:1337" + obj.attributes?.profilePic?.data?.attributes?.url).into(profildetail)
        analogy.text = obj.attributes?.analogy

        animasi.setVideoPath("http://192.168.89.8:1337" + obj.attributes?.equation?.data?.attributes?.url)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(animasi)
        animasi.setMediaController(mediaController)
        animasi.requestFocus()
        animasi.start()
//        Glide.with(this).load("http://192.168.124.8:1337" + obj.attributes?.equation?.data?.attributes?.url).into(rumus)
        isimateri.text = obj.attributes?.explanation

    }
}