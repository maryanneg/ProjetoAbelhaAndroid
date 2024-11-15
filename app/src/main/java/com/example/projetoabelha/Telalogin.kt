package com.example.projetoabelha

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoabelha.databinding.ActivityTelaloginBinding
import com.example.projetoabelha.util.UserDatabaseHelper

class Telalogin : ComponentActivity() {
    private lateinit var dbHelper: UserDatabaseHelper
    private lateinit var binding: ActivityTelaloginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val db = dbHelper.readableDatabase
        val email = binding.email.text.toString()
        val password = binding.senha.text.toString()

        val cursor = db.rawQuery(
            "SELECT * FROM ${UserDatabaseHelper.TABLE_NAME} WHERE ${UserDatabaseHelper.COLUMN_EMAIL} = ? AND ${UserDatabaseHelper.COLUMN_PASSWORD} = ?",
            arrayOf(email, password)
        )

        if (cursor.moveToFirst()) {
            Toast.makeText(this, "Login realizado com sucesso.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Enxames::class.java))
            finish()
        } else {
            Toast.makeText(this, "E-mail ou Senha Inválido!", Toast.LENGTH_LONG).show()
        }
        cursor.close()
    }
}
