package com.example.myphysicsapps.materi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myphysicsapps.MateriResponse
import com.example.myphysicsapps.adapter.MateriAdapter
import com.example.myphysicsapps.R
import com.example.myphysicsapps.databinding.ActivityMateriBinding
import com.example.myphysicsapps.materiViewModel

class MateriActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMateriBinding
    private lateinit var viewModel: materiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityMateriBinding.inflate(layoutInflater)
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
    private fun setlistUser(data: MateriResponse){
        val layoutManager = LinearLayoutManager(this)
        binding.RvMateri.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.RvMateri.addItemDecoration(itemDecoration)
        val adapter = MateriAdapter(data)
        binding.RvMateri.adapter = adapter
    }
}