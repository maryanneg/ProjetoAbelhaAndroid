package com.example.projetoabelha

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoabelha.databinding.ActivityTelaloginBinding

class Telalogin : ComponentActivity() {
    private lateinit var binding: ActivityTelaloginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTelaloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener {
            irParaTelaEnxames()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun irParaTelaEnxames() {
        val email = binding.email.text.toString().trim()
        val senha = binding.senha.text.toString().trim()
        if(email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(applicationContext,"E-mail ou senha não inseridos!", Toast.LENGTH_SHORT).show()
        }else if((email != "email" && !email.isEmpty()) || (senha != "senha" && !senha.isEmpty())){
            Toast.makeText(this,"E-mail ou Senha Inválido!", Toast.LENGTH_LONG).show()
        }else{
            startActivity(Intent(this, Enxames::class.java))
        }

    }
}

