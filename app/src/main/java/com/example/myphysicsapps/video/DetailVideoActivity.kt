package com.example.myphysicsapps.video

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.example.myphysicsapps.DataItem
import com.example.myphysicsapps.R
import com.example.myphysicsapps.materi.Materi
import com.google.gson.Gson

class DetailVideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_video)

        supportActionBar?.hide()

        val gson = Gson()

        val judul = intent.getStringExtra("judul")
        val obj : DataItem = gson.fromJson(judul, DataItem::class.java)

        val video: VideoView = this.findViewById(R.id.videoView)

        video.setVideoPath("http://192.168.89.8:1337" + obj.attributes?.video?.data?.attributes?.url)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)
        video.setMediaController(mediaController)
        video.requestFocus()
        video.start()
    }
}