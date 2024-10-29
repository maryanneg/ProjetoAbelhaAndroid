package com.example.projetoabelha

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.projetoabelha.databinding.TelainicialBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: TelainicialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelainicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btInicial.setOnClickListener {
            irParaLogin()
        }
        binding.btcadastreSe.setOnClickListener {
            irParaCadastro()
        }
    }
    private fun irParaLogin() {
        startActivity(Intent(this, Telalogin::class.java))
    }
    private fun irParaCadastro() {
        startActivity(Intent(this, Cadastro::class.java))
    }
}


