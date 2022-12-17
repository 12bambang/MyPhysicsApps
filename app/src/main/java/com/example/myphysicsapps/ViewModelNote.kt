package com.example.myphysicsapps

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myphysicsapps.database.EntityNote
import com.example.myphysicsapps.database.NoteRepo

class ViewModelNote(application: Application): ViewModel() {
    private val _noterepo: NoteRepo = NoteRepo(application)

    fun getNote(): LiveData<List<EntityNote>> = _noterepo.getNote()
}