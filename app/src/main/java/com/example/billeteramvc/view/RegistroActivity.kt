package com.example.billeteramvc.view // Revisa que coincida con tu paquete

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.billeteramvc.R

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro2)

        val etCorreo = findViewById<EditText>(R.id.etRegistroCorreo)
        val etContrasena = findViewById<EditText>(R.id.etRegistroContrasena)
        val btnRegistrarCuenta = findViewById<Button>(R.id.btnRegistrarCuenta)

        btnRegistrarCuenta.setOnClickListener {
            val correo = etCorreo.text.toString().trim()
            val contrasena = etContrasena.text.toString().trim()

            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Usamos Context.MODE_PRIVATE de forma explícita
                val preferences = getSharedPreferences("BilleteraUserPrefs", Context.MODE_PRIVATE)
                val editor = preferences.edit()

                editor.putString("USER_EMAIL", correo)
                editor.putString("USER_PASSWORD", contrasena)

                // commit() asegura la grabación física en disco inmediatamente
                val exito = editor.commit()

                if (exito) {
                    Toast.makeText(this, "¡Registro exitoso! Ya puedes iniciar sesión", Toast.LENGTH_SHORT).show()
                    finish() // Cierra la pantalla y vuelve a Login
                } else {
                    Toast.makeText(this, "Error al guardar en el dispositivo", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}