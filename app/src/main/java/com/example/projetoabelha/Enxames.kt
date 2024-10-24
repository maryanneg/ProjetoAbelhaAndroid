package com.example.projetoabelha

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Enxames : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_enxames)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btAdicionar = findViewById<Button>(R.id.bt_adicionar)
        btAdicionar.setOnClickListener {
            irParaTelaAdicionar()
        }
    }

    private fun irParaTelaAdicionar() {
        val telaAdicionar = Intent(this, Adicionar::class.java)
        startActivity(telaAdicionar)
    }
}