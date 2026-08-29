package com.example.billeteramvc.view // Asegúrate de que coincida con tu paquete real

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.billeteramvc.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Enlaza con el XML anterior

        // Vinculamos los componentes del XML por su ID
        val etCorreo = findViewById<EditText>(R.id.etLoginCorreo)
        val etContrasena = findViewById<EditText>(R.id.etLoginContrasena)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        // Acción al presionar el botón Ingresar
        btnIngresar.setOnClickListener {
            val correo = etCorreo.text.toString()
            val contrasena = etContrasena.text.toString()

            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Intentando ingresar con: $correo", Toast.LENGTH_SHORT).show()
                // Aquí irá tu lógica para conectar con una base de datos o validar el MVC
            }
        }
    }
}
