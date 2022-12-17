package com.example.myphysicsapps.database

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepo(application: Application) {
    private val _daonote : DaoNote
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = databaseNote.getDatabase(application)
        _daonote= db.daoNote()
    }

    fun getNote(): LiveData<List<EntityNote>> = _daonote.getNote()

    fun insert(note: EntityNote){
        executorService.execute { _daonote.insert(note) }
    }
    fun delete(note: EntityNote){
        executorService.execute { _daonote.delete(note) }
    }
    fun update(note: EntityNote){
        executorService.execute { _daonote.update(note) }
    }


}