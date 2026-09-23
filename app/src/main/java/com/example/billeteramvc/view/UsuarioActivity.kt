package com.example.billeteramvc.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.billeteramvc.R

class UsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario) // Crea su XML correspondiente

        val tvCorreo = findViewById<TextView>(R.id.tvPerfilCorreo)

        // Recibir el correo pasado desde BilleteraActivity
        val email = intent.getStringExtra("EXTRA_USUARIO_EMAIL") ?: "No disponible"
        tvCorreo.text = "Correo registrado: $email"
    }
}