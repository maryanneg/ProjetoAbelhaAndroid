package com.example.projetoabelha.util

import Enxamme
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
        const val COLUMN_DATE = "date"
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

    fun insertEnxame(especie: String, origem: String, descricao: String, date: String):Boolean {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_SPECIES, especie)
            put(COLUMN_ORIGIN, origem)
            put(COLUMN_DESCRIPTION, descricao)
            put(COLUMN_DATE, date)
        }

        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return result != -1L
    }

    fun getAllEnxames(): List<Enxamme> {
        val enxames = mutableListOf<Enxamme>()
        val db = readableDatabase
        val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)

        if(cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val especie = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SPECIES))
                val origem = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ORIGIN))
                val descricao = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION))
                val date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))

                enxames.add(Enxamme(id.toString(), especie, origem, descricao, date))
            } while(cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return enxames
    }

}