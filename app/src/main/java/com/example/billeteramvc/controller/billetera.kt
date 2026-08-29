package com.example.billeteramvc.controller


import com.example.billeteramvc.model.BancoDatos
import com.example.billeteramvc.model.Usuario

class BilleteraController {

    // 1. Lógica para registrar un usuario
    fun registrarUsuario(nombre: String, correo: String, contrasena: String): String {
        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            return "Todos los campos son obligatorios."
        }

        // Verificar si el correo ya existe
        val existe = BancoDatos.listaUsuarios.any { it.correo == correo }
        if (existe) {
            return "El correo ya está registrado."
        }

        // Crear y guardar el nuevo usuario
        val nuevoUsuario = Usuario(correo, contrasena, nombre, saldo = 0.0)
        BancoDatos.listaUsuarios.add(nuevoUsuario)
        return "Registro exitoso."
    }

    // 2. Lógica para iniciar sesión (Login)
    fun iniciarSesion(correo: String, contrasena: String): Boolean {
        val usuarioEncontrado = BancoDatos.listaUsuarios.find {
            it.correo == correo && it.contrasena == contrasena
        }

        if (usuarioEncontrado != null) {
            BancoDatos.usuarioActual = usuarioEncontrado
            return true
        }
        return false
    }

    // 3. Lógica para realizar un depósito
    fun procesarDeposito(montoTexto: String): String {
        val monto = montoTexto.toDoubleOrNull()
        if (monto == null || monto <= 0) {
            return "Monto inválido."
        }

        val usuario = BancoDatos.usuarioActual ?: return "Error: No hay sesión activa."

        if (usuario.depositar(monto)) {
            return "Depósito de $$monto realizado con éxito."
        }
        return "No se pudo realizar el depósito."
    }

    // 4. Lógica para realizar un giro (retiro)
    fun procesarGiro(montoTexto: String): String {
        val monto = montoTexto.toDoubleOrNull()
        if (monto == null || monto <= 0) {
            return "Monto inválido."
        }

        val usuario = BancoDatos.usuarioActual ?: return "Error: No hay sesión activa."

        if (usuario.girar(monto)) {
            return "Giro de $$monto realizado con éxito."
        }
        return "Saldo insuficiente o monto inválido."
    }

    // 5. Obtener los datos del usuario logueado
    fun obtenerUsuarioActual(): Usuario? {
        return BancoDatos.usuarioActual
    }

    // 6. Cerrar sesión
    fun cerrarSesion() {
        BancoDatos.usuarioActual = null
    }
}
