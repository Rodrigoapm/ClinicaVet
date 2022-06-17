package com.example.clinicaveterinaria

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Clientes(var nome: String, var id: Long = -1) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDClientes.CAMPO_NOME, nome)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Clientes {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaBDClientes.CAMPO_NOME)

            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)

            return Clientes(nome, id)
        }
    }
}