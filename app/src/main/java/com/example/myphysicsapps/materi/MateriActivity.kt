package com.example.myphysicsapps.materi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myphysicsapps.adapter.MateriAdapter
import com.example.myphysicsapps.R

class MateriActivity : AppCompatActivity() {
    private lateinit var RvMateri: RecyclerView
    private var list: ArrayList<Materi> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        RvMateri = findViewById(R.id.RvMateri)
        RvMateri.setHasFixedSize(true)

        list.addAll(listMateri)
        showRecyclerList()

    }

    private val listMateri: ArrayList<Materi>
        get() {
            val judul = resources.getStringArray(R.array.judul)
            val foto = resources.obtainTypedArray(R.array.foto)
            val analogy = resources.getStringArray(R.array.analogy)
            val rumus = resources.obtainTypedArray(R.array.rumus)
            val penjelasan = resources.getStringArray(R.array.penjelasan)

            val listMateri = ArrayList<Materi>()
            for (i in judul.indices) {
                val materi = Materi(
                    judul[i],
                    foto.getResourceId(i, -1),
                    analogy[i],
                    rumus.getResourceId(i, -1),
                    penjelasan[i])
                listMateri.add(materi)
            }
            return listMateri
        }

    private fun showRecyclerList() {
        RvMateri.layoutManager = LinearLayoutManager(this)
        val listMateriAdapter = MateriAdapter(list)
        RvMateri.adapter = listMateriAdapter

    }
}