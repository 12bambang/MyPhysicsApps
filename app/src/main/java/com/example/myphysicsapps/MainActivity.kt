package com.example.myphysicsapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.example.myphysicsapps.catatan.Note
import com.example.myphysicsapps.materi.MateriActivity
import com.example.myphysicsapps.quiz.QuizActivity
import com.example.myphysicsapps.video.VideoActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        val crdButtonMateri: CardView = findViewById(R.id.btnMateri)
        crdButtonMateri.setOnClickListener(this)

        val crdButtonVideo: CardView = findViewById(R.id.btnVideo)
        crdButtonVideo.setOnClickListener(this)

        val crdButtonQuiz: CardView = findViewById(R.id.btnKuiz)
        crdButtonQuiz.setOnClickListener(this)

        val crdButtonNote: CardView = findViewById(R.id.btnNote)
        crdButtonNote.setOnClickListener(this)

        val crdButtonAbout: CardView = findViewById(R.id.btnAbout)
        crdButtonAbout.setOnClickListener(this)

    }
    override fun onClick(view: View) {
        when (view.id){
            R.id.btnMateri ->{
                val moveMateri = Intent(this@MainActivity, MateriActivity::class.java)
                moveMateri.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveMateri)
            }

            R.id.btnVideo ->{
                val moveVideo = Intent(this@MainActivity, VideoActivity::class.java)
                moveVideo.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveVideo)
            }

            R.id.btnKuiz -> {
                val moveQuiz = Intent(this@MainActivity, QuizActivity::class.java)
                moveQuiz.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveQuiz)
            }

            R.id.btnNote -> {
                val moveNote = Intent(this@MainActivity, Note::class.java)
                moveNote.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveNote)
            }
            R.id.btnAbout -> {
                val moveAbout = Intent(this@MainActivity,AboutActivity::class.java)
                moveAbout.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(moveAbout)
            }
        }
    }
}