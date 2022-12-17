package com.example.myphysicsapps.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoNote {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert (note: EntityNote)

    @Update
    fun update (note: EntityNote)

    @Delete
    fun delete (note: EntityNote)

    @Query ("SELECT * From EntityNote ORDER BY id ASC")
    fun getNote(): LiveData<List<EntityNote>>
}