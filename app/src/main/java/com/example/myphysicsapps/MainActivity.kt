package com.example.myphysicsapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.myphysicsapps.catatan.Note
import com.example.myphysicsapps.materi.MateriActivity
import com.example.myphysicsapps.quiz.QuizActivity
import com.example.myphysicsapps.video.VideoActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        val imgButtonMateri: ImageButton = findViewById(R.id.imgButtonMateri)
        imgButtonMateri.setOnClickListener(this)

        val imgButtonVideo: ImageButton = findViewById(R.id.imgButtonVideo)
        imgButtonVideo.setOnClickListener(this)

        val imgButtonQuiz: ImageButton = findViewById(R.id.imgButtonQuiz)
        imgButtonQuiz.setOnClickListener(this)

        val imgButtonNote: ImageButton = findViewById(R.id.imgButtonNote)
        imgButtonNote.setOnClickListener(this )

    }
    override fun onClick(view: View) {
        when (view.id){
            R.id.imgButtonMateri ->{
                val moveMateri = Intent(this@MainActivity, MateriActivity::class.java)
                moveMateri.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveMateri)
            }

            R.id.imgButtonVideo ->{
                val moveVideo = Intent(this@MainActivity, VideoActivity::class.java)
                moveVideo.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveVideo)
            }

            R.id.imgButtonQuiz -> {
                val moveQuiz = Intent(this@MainActivity, QuizActivity::class.java)
                moveQuiz.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveQuiz)
            }

            R.id.imgButtonNote -> {
                val moveNote = Intent(this@MainActivity, Note::class.java)
                moveNote.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveNote)
            }
        }
    }
}