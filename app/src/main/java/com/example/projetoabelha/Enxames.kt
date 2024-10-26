package com.example.projetoabelha

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoabelha.databinding.ActivityEnxamesBinding
import com.example.projetoabelha.databinding.ActivityTelaloginBinding

class Enxames : ComponentActivity() {
    private lateinit var binding: ActivityEnxamesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnxamesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listaEnchames = ArrayList<Enchames>()
        listaEnchames.add(Enchames("Urucu","compra","nordestina","22/22/2222"))
        listaEnchames.add(Enchames("Jatai","doacao","paulista","33/33/3333"))

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaEnchames)
        binding.listViewEnxames.adapter = adapter

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