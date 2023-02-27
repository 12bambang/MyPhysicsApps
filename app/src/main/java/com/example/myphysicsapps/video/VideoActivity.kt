package com.example.myphysicsapps.video

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myphysicsapps.MateriResponse
import com.example.myphysicsapps.R
import com.example.myphysicsapps.adapter.MateriAdapter
import com.example.myphysicsapps.adapter.vidAdapter
import com.example.myphysicsapps.databinding.ActivityVideoBinding
import com.example.myphysicsapps.materi.Materi
import com.example.myphysicsapps.materiViewModel


class VideoActivity : AppCompatActivity(){
    private lateinit var binding: ActivityVideoBinding
    private lateinit var viewModel: materiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(materiViewModel::class.java)

        viewModel.materiSearch.observe(this) {
            setlistUser(it)
        }

        viewModel.SearchMateri()

    }

    private fun setlistUser(data: MateriResponse) {
        val layoutManager = LinearLayoutManager(this)
        binding.rvVideo.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvVideo.addItemDecoration(itemDecoration)
        val adapter = vidAdapter(data)
        binding.rvVideo.adapter = adapter
    }
}

