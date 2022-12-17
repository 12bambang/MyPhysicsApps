package com.example.myphysicsapps.materi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myphysicsapps.R

class DetailActivityMateri : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_materi)

        var imgProfileDetail : ImageView = findViewById(R.id.profildetail)
        var tvJudulDetail : TextView = findViewById(R.id.juduldetail)
        var tvAnalogy : TextView = findViewById(R.id.analogy)
        var imgRumus : ImageView = findViewById(R.id.rumus)
        var tvIsiMateri : TextView = findViewById(R.id.isiMateri)


        val materi = intent.getParcelableExtra<Materi>("parcelable") as Materi

        Glide.with(this)
            .load(materi.foto)
            .into(imgProfileDetail)

        tvJudulDetail.text = materi.judul
        tvAnalogy.text = materi.analogy

        Glide.with(this)
            .load(materi.rumus)
            .into(imgRumus)

        tvIsiMateri.text = materi.penjelasan
    }
}