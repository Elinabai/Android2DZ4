package com.geektech.android2dz4.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.geektech.android2dz4.model.NoteModel
import java.util.*
import kotlin.collections.List as List1

@Dao

interface NotDao {

    @Query("SELECT * FROM Note")
    fun getAll():LiveData<List1<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (noteModel: NoteModel)

    @Delete
    fun delete(model: NoteModel)
}