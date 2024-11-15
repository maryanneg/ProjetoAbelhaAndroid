package com.example.projetoabelha
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoabelha.adapter.EnxameListAdapter
import com.example.projetoabelha.databinding.ActivityEnxamesBinding
import com.example.projetoabelha.util.EnxameDatabaseHelper

class Enxames : ComponentActivity() {
    private lateinit var binding: ActivityEnxamesBinding
    private lateinit var dbHelper: EnxameDatabaseHelper
    private lateinit var enxameAdapter: EnxameListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnxamesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        dbHelper = EnxameDatabaseHelper(this)

        val enxames = dbHelper.getAllEnxames().toMutableList()

        enxameAdapter = EnxameListAdapter(
            this,
            enxames
        )

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = enxameAdapter




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