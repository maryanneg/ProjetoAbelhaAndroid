package com.example.projetoabelha

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin = findViewById<Button>(R.id.bt_login)
        btnLogin.setOnClickListener{
            login()
        }
    }


    private fun login(){
        val db = dbHelper.readableDatabase

        val email = findViewById<EditText>(R.id.email).text.toString()
        val password = findViewById<EditText>(R.id.senha).text.toString()

        val cursor = db.rawQuery(
            "SELECT * FROM ${UserDatabaseHelper.TABLE_NAME} WHERE ${UserDatabaseHelper.COLUMN_EMAIL} = ? AND ${UserDatabaseHelper.COLUMN_PASSWORD} = ?",
            arrayOf(email, password)
        )

        if(cursor.moveToFirst()) {
            Toast.makeText(this, "Login realizado com sucesso.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Enxames::class.java))
            finish()
        } else {
            Toast.makeText(this,"E-mail ou Senha Inválido!", Toast.LENGTH_LONG).show()
        }
    }
}

