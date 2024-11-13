package com.example.projetoabelha.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users (
    @ColumnInfo(name = "primeiro_nome") val primeiroNome: String,
    @ColumnInfo(name = "ultimo_nome") val ultimoNome: String,
    @ColumnInfo(name = "email")val email: String,
    @ColumnInfo(name = "senha")val senha: String,
    @ColumnInfo(name = "celular")val celular: Int,
    @ColumnInfo(name = "data_nasc")val dataNasc: Int
){
    @PrimaryKey(autoGenerate = true)
    val uid:Int =0
}
