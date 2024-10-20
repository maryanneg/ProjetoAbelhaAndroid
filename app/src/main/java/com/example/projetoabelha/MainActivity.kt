package com.example.projetoabelha

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telainicial)

        // Corrigindo o ID do botão para btinicial
        val btInicial = findViewById<Button>(R.id.bt_inicial)

        btInicial.setOnClickListener {
            irParaLogin()
        }
    }

    private fun irParaLogin() {

        val telaLogin = Intent(this, Telalogin::class.java)
        startActivity(telaLogin)
    }
}


