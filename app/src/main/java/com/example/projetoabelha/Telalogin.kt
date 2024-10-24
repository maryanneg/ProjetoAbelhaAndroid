package com.example.projetoabelha

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Telalogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_telalogin)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btLogin = findViewById<Button>(R.id.bt_login)
        btLogin.setOnClickListener {
            irParaTelaEnxames()
        }
    }

    private fun irParaTelaEnxames() {
        val telaEnxames = Intent(this, Enxames::class.java)
        startActivity(telaEnxames)
    }
}
