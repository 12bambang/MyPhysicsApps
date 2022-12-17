package com.example.myphysicsapps.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntityNote::class], version = 1)
abstract class databaseNote : RoomDatabase() {
    abstract fun daoNote(): DaoNote

    companion object {
        @Volatile
        private var INSTANCE: databaseNote? = null

        @JvmStatic
        fun getDatabase(context: Context): databaseNote {
            if (INSTANCE == null) {
                synchronized(databaseNote::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        databaseNote::class.java,
                        "note_database"
                    )
                        .build()
                }
            }
            return INSTANCE as databaseNote
        }
    }
}
