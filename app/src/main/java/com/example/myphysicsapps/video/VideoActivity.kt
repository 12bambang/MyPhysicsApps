package com.example.myphysicsapps.video

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.example.myphysicsapps.R


class VideoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        supportActionBar?.hide()
        
        val videoView : VideoView = findViewById(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val Video = Uri.parse("android.resource://$packageName/${R.raw.fisika}")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(Video)
        videoView.requestFocus()
        videoView.start()
    }

}

