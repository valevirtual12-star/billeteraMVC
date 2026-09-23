package com.example.billeteramvc.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.billeteramvc.R
import com.example.billeteramvc.model.BancoDatos
import com.example.billeteramvc.model.Usuario
import com.example.billeteramvc.view.BancoDatosActivity
import com.example.billeteramvc.view.UsuarioActivity

class BilleteraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billetera1)

        val tvCorreo = findViewById<TextView>(R.id.tvUsuarioEmail)
        val tvSaldo = findViewById<TextView>(R.id.tvSaldo)
        val tvBanco = findViewById<TextView>(R.id.tvNombreBanco)

        val btnVerUsuario = findViewById<Button>(R.id.btnVerUsuario)
        val btnVerBanco = findViewById<Button>(R.id.btnVerBanco)

        // Obtener el correo recibido
        val email = intent.getStringExtra("EXTRA_USUARIO_EMAIL") ?: "Sin correo"

        val usuarioActual = Usuario(correo = email, contrasena = "")
        val datosBancarios = BancoDatos(saldo = 150000.0, numeroCuenta = "123456789", banco = "Banco Estado")

        tvCorreo.text = "Usuario: ${usuarioActual.correo}"
        tvSaldo.text = "Saldo disponible: $${datosBancarios.saldo}"
        tvBanco.text = "Banco: ${datosBancarios.banco}"

        // 1. Evento para abrir Perfil de Usuario
        btnVerUsuario.setOnClickListener {
            val intent = Intent(this, UsuarioActivity::class.java)
            intent.putExtra("EXTRA_USUARIO_EMAIL", email)
            startActivity(intent)
        }

        // 2. Evento para abrir Datos Bancarios
        btnVerBanco.setOnClickListener {
            val intent = Intent(this, BancoDatosActivity::class.java)
            startActivity(intent)
        }
    }
}