package com.example.myphysicsapps

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.myphysicsapps.database.EntityNote
import com.example.myphysicsapps.database.NoteRepo

class NoteUpdateViewModel(application: Application): ViewModel() {
    private val _noteRepo: NoteRepo = NoteRepo(application)

    fun insert(note: EntityNote){
        _noteRepo.insert(note)
    }
    fun update(note: EntityNote){
        _noteRepo.update(note)
    }
    fun delete(note: EntityNote){
        _noteRepo.delete(note)
    }
}