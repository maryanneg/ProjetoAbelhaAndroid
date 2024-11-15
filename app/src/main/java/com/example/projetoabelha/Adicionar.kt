package com.example.projetoabelha

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoabelha.databinding.ActivityAdicionarBinding
import com.example.projetoabelha.util.EnxameDatabaseHelper

class Adicionar : ComponentActivity() {
    private lateinit var dbHelper: EnxameDatabaseHelper
    private lateinit var binding: ActivityAdicionarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdicionarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = EnxameDatabaseHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referência ao Spinner
        val spinner1: Spinner = findViewById(R.id.especie)
        val spinner2: Spinner = findViewById(R.id.origem)

        // Lista de opções
        val opcoes1 = listOf("Uruçu", "Jataí", "Mandaçaia")
        val opcoes2 = listOf("Compra", "Captura", "Doação")

        val imageMap = mapOf(
            "Uruçu" to R.drawable.urucu,
            "Jataí" to R.drawable.jatai,
            "Mandaçaia" to R.drawable.mandacaia
        )

        // Adaptador para preencher o Spinner
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoes1).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoes2).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Vincular o adaptador ao Spinner
        spinner1.adapter = adapter1
        spinner2.adapter = adapter2

        binding.salvar.setOnClickListener {
            cadastrarEnxame()
        }
        binding.voltar.setOnClickListener {
            irParaTelaEnxames()
        }


    }

    private fun cadastrarEnxame() {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("especie", binding.especie.selectedItem.toString())
            put("origem", binding.origem.selectedItem.toString())
            put("descricao", binding.descricao.text.toString())
            put("date", binding.dataDia.text.toString())
        }

        val newRowId = db.insert(EnxameDatabaseHelper.TABLE_NAME, null, values)
        if (newRowId != -1L) {
            Toast.makeText(this, "Enxame cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
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
