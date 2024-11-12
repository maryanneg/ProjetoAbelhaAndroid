package com.example.projetoabelha.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projetoabelha.database.daos.UserDao
import com.example.projetoabelha.database.models.Users

@Database(entities = [Users::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun userDao():UserDao

    companion object{
        private const val DATABASE_NAME: String = "Banco-de-Dados"
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, DATABASE_NAME
            ).build()
    }

}