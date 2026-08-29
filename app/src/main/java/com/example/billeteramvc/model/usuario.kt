package com.example.billeteramvc.model

data class Usuario(
    val correo: String,
    val contrasena: String,
    val nombre: String,
    var saldo: Double = 0.0
) {
    fun depositar(monto: Double): Boolean {
        if (monto > 0) {
            saldo += monto
            return true
        }
        return false
    }

    fun girar(monto: Double): Boolean {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto
            return true
        }
        return false
    }
}
