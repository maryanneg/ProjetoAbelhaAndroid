package com.example.projetoabelha

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoabelha.util.UserDatabaseHelper

class RecuperarSenha : AppCompatActivity() {
    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recuperar_senha)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dbHelper = UserDatabaseHelper(this)

        val btnSalvarNovaSenha = findViewById<Button>(R.id.btnSalvarNovaSenha)
        btnSalvarNovaSenha.setOnClickListener {
            val email = findViewById<EditText>(R.id.editEmailRec).text.toString()
            val novaSenha = findViewById<EditText>(R.id.editNovaSenha).text.toString()
            val confSenha = findViewById<EditText>(R.id.editConfSenha).text.toString()

            if (novaSenha == confSenha) {
                val success = dbHelper.updatePassword(email, novaSenha)
                if (success) {
                    Toast.makeText(this, "Senha atualizada com sucesso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erro ao atualizar a senha", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
            }
        }
    }
}