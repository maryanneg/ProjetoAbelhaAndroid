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
import com.example.projetoabelha.util.EnxameDatabaseHelper

class Adicionar : ComponentActivity() {

    private lateinit var dbHelper : EnxameDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)

        dbHelper = EnxameDatabaseHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCadastrar = findViewById<Button>(R.id.salvar)
        btnCadastrar.setOnClickListener{
            cadastrarEnxame()
        }

        val btnVoltar = findViewById<Button>(R.id.voltar)
        btnVoltar.setOnClickListener {
            irParaTelaEnxames()
        }
    }

    private fun cadastrarEnxame() {
        val db = dbHelper.writableDatabase

        val especie = findViewById<EditText>(R.id.especie).text.toString()
        val origem = findViewById<EditText>(R.id.origem).text.toString()
        val descricao = findViewById<EditText>(R.id.descricao).text.toString()
        val data = findViewById<EditText>(R.id.data).text.toString()

        val values = ContentValues().apply {
            put("especie", especie)
            put("origem", origem)
            put("descricao", descricao)
            put("data", data)
        }

        val newRowId = db.insert(EnxameDatabaseHelper.TABLE_NAME, null, values)
        if(newRowId != -1L) {
            Toast.makeText(this, "Enxame cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show()
            irParaTelaEnxames()
        } else {
            Toast.makeText(this, "Erro ao cadastrar enxame...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun irParaTelaEnxames() {
        val telaEnxames = Intent(this, Enxames::class.java)
        startActivity(telaEnxames)
    }
}