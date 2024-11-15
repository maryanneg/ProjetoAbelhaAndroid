package com.example.projetoabelha

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoabelha.util.UserDatabaseHelper

class Adicionar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adicionar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btVoltar = findViewById<Button>(R.id.voltar)
        btVoltar.setOnClickListener {
            irParaTelaEnxames()
        }

        val btAdicionar = findViewById<Button>(R.id.salvar)
        btAdicionar.setOnClickListener {
            cadastrarEnxame()
        }
    }

    private fun cadastrarEnxame() {
        val db = dbHelper.writableDatabase

        val especie = findViewById<EditText>(R.id.especie).text.toString()
        val origem = findViewById<EditText>(R.id.origem).text.toString()
        val descricao = findViewById<EditText>(R.id.descricao).text.toString()
        val dataDia = findViewById<EditText>(R.id.dataDia).text.toString()
        val imagem = findViewById<EditText>(R.id.buttonSelectImage).text.toString() //imagem corrigir

        val values = ContentValues().apply {
            put("especie", especie)
            put("origem", origem)
            put("descricao", descricao)
            put("dataDia", dataDia)
            put("imagem", imagem)
        }

        val newRowId = db.insert(UserDatabaseHelper.TABLE_NAME, null, values)
        if(newRowId != -1L) {
            Toast.makeText(this, "Enxame foi cadastrado com sucesso.", Toast.LENGTH_SHORT).show()
            irParaTelaEnxames()
        } else {
            Toast.makeText(this, "Erro ao cadastrar Enxame.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun irParaTelaEnxames() {
        val telaEnxames = Intent(this, Enxames::class.java)
        startActivity(telaEnxames)
    }
}