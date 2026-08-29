package com.example.billeteramvc.view // ⚠️ Asegúrate de cambiar esto por el nombre real de tu paquete

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.billeteramvc.R

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro) // 🛠️ Reemplaza 'activity_registro' por el nombre exacto de tu archivo XML de registro

        // 1. Vinculamos los componentes del XML con variables de Kotlin usando sus IDs
        val etNombre = findViewById<EditText>(R.id.etRegistroNombre)
        val etCorreo = findViewById<EditText>(R.id.etRegistroCorreo)
        val etContrasena = findViewById<EditText>(R.id.etRegistroContrasena)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val tvVolverLogin = findViewById<TextView>(R.id.tvVolverLogin)

        // 2. Acción al presionar el botón "Registrarse"
        btnRegistrar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val contrasena = etContrasena.text.toString().trim()

            // Validación básica de campos vacíos
            if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí procesas los datos (los envías a tu Controlador del patrón MVC)
                Toast.makeText(this, "¡Cuenta creada para $nombre!", Toast.LENGTH_SHORT).show()

                // Opcional: Redirigir al Login automáticamente tras registrarse
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Cierra esta pantalla para que el usuario no regrese al presionar "atrás"
            }
        }

        // 3. Acción al presionar el texto "¿Ya tienes cuenta? Inicia sesión"
        tvVolverLogin.setOnClickListener {
            // Creamos un Intent para saltar de la pantalla de Registro a la pantalla de Login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Cierra la pantalla de registro para no acumular actividades en memoria
        }
    }
}
