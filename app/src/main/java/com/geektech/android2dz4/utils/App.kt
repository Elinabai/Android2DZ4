package com.geektech.android2dz4.utils

import android.app.Application
import androidx.room.Room
import com.geektech.android2dz4.data.db.daos.AppDataBase

class App: Application() {

    companion object{
        var appDataBase: AppDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        getInstance()
    }

     fun getInstance(): AppDataBase? {
        if (appDataBase == null){
            appDataBase = applicationContext?.let {
                Room.databaseBuilder(
                    it,
                    AppDataBase:: class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDataBase
     }
}

