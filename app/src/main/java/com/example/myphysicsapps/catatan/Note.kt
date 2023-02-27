package com.example.myphysicsapps.catatan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myphysicsapps.R
import com.example.myphysicsapps.ViewModelFactory
import com.example.myphysicsapps.ViewModelNote
import com.example.myphysicsapps.databinding.ActivityNoteBinding

class Note : AppCompatActivity() {
    private var _activitynotebinding: ActivityNoteBinding? = null
    private val binding get() = _activitynotebinding

    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Note"

        _activitynotebinding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val viewmodelNote = obtainViewModel(this@Note)
        viewmodelNote.getNote().observe(this, { noteList ->

            if (noteList != null) {
                adapter.setListNotes(noteList)
            }
        })

        adapter = NoteAdapter()
        binding?.rvNotes?.layoutManager = LinearLayoutManager(this)
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter

        binding?.fabAdd?.setOnClickListener { view ->
            if (view.id == R.id.fab_add) {
                val intent = Intent(this@Note, NoteUpdate::class.java)
                startActivity(intent)
            }
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): ViewModelNote {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ViewModelNote::class.java)
    }
}

