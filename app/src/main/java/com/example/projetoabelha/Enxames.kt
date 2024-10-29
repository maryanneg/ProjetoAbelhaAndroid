package com.example.projetoabelha
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoabelha.adapter.EnxameListAdapter
import com.example.projetoabelha.data.EnxameMock
import com.example.projetoabelha.databinding.ActivityEnxamesBinding

class Enxames : ComponentActivity() {
    private lateinit var binding: ActivityEnxamesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnxamesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val mock = EnxameMock()
        binding.recyclerView.adapter = EnxameListAdapter(mock.listaEnxames)



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