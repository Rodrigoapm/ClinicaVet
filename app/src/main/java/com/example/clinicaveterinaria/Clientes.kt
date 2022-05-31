package com.example.clinicaveterinaria

import android.content.ContentValues

class Clientes (var id: Long, var nome: String) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDClientes.CAMPO_NOME, nome)

        return valores
    }
}