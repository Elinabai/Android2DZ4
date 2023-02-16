package com.geektech.android2dz4.data.db.daos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.android2dz4.model.NoteModel

@Database(entities = [NoteModel::class], version = 3)

abstract class AppDataBase : RoomDatabase() {
    abstract fun noteDao(): NotDao

}