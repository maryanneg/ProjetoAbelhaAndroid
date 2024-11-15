package com.example.projetoabelha

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoabelha.databinding.ActivityCadastroBinding
import com.example.projetoabelha.util.UserDatabaseHelper

class Cadastro : ComponentActivity() {
    private lateinit var dbHelper: UserDatabaseHelper
    private lateinit var binding: ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCadastrar = findViewById<Button>(R.id.salvar_cadastro)
        btnCadastrar.setOnClickListener{
            cadastrarUsuario()
        }
    }

    private fun cadastrarUsuario() {
        val db = dbHelper.writableDatabase

        val name = findViewById<EditText>(R.id.nome_usuario).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        val email = findViewById<EditText>(R.id.Email).text.toString()
        val phone = findViewById<EditText>(R.id.phone_usuario).text.toString()
        val birth = findViewById<EditText>(R.id.data_nascimento_usuario).text.toString()

        val values = ContentValues().apply {
            put("name", name)
            put("password", password)
            put("email", email)
            put("phone", phone)
            put("birth", birth)
        }

        val newRowId = db.insert(UserDatabaseHelper.TABLE_NAME, null, values)
        if((newRowId != -1L) && (validarCampos(name, email, password))) {
            Toast.makeText(this, "Usuário foi cadastrado com sucesso.", Toast.LENGTH_SHORT).show()
            retornar()
        } else {
            Toast.makeText(this, "Erro ao cadastrar usuário (verifique os campos).", Toast.LENGTH_SHORT).show()
        }
    }

    private fun retornar() {
        val intent = Intent(this, Telalogin::class.java)
        startActivity(intent)
    }
    fun validarCampos(name: String, email: String, password: String): Boolean {
        if (name.isBlank()) {
            println("O campo 'Nome' não pode estar vazio.")
            return false
        }
        if (email.isBlank()) {
            println("O campo 'Email' não pode estar vazio.")
            return false
        }
        if (password.isBlank()) {
            println("O campo 'Senha' não pode estar vazio.")
            return false
        }
        return true
    }
}