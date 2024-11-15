package com.example.projetoabelha.util

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EnxameDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "enxame.db"
        const val TABLE_NAME = "enxame"
        const val COLUMN_ID = "_id"
        const val COLUMN_SPECIES = "especie"
        const val COLUMN_ORIGIN = "origem"
        const val COLUMN_DESCRIPTION = "descricao"
        const val COLUMN_DATE = "data"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """ 
            CREATE TABLE $TABLE_NAME(
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_SPECIES TEXT,
            $COLUMN_ORIGIN TEXT,
            $COLUMN_DESCRIPTION TEXT,
            $COLUMN_DATE TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertEnxame(especie: String, origem: String, descricao: String, data: String):Boolean {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_SPECIES, especie)
            put(COLUMN_ORIGIN, origem)
            put(COLUMN_DESCRIPTION, descricao)
            put(COLUMN_DATE, data)
        }

        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return result != -1L
    }

}