package com.example.myphysicsapps.video

import com.example.myphysicsapps.R

object videoobj {

    private val materi = arrayOf(
        "Besaran dan satuan"
    )
    private val profilpic = intArrayOf(
        R.drawable.besaransatuan
    )
    private val video = intArrayOf(
        R.raw.fisika
    )

    val listVideo: ArrayList<vidfisika>
    get() {
        val list = arrayListOf<vidfisika>()
        for (position in materi.indices) {
            val vidfisika = vidfisika()
            vidfisika.materi = materi[position]
            vidfisika.profilpic = profilpic[position]
            vidfisika.Video = video[position]
        }
        return list
    }
}