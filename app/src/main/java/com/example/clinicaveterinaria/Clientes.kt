package com.example.clinicaveterinaria

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Clientes(var nome: String, var idade: String, var nif, var contacto, var id: Long = -1) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDCliente.CAMPO_NOME, nome)
        valores.put(TabelaBDCliente.CAMPO_IDADE, idade)
        valores.put(TabelaBDCliente.CAMPO_NIF, nif)
        valores.put(TabelaBDCliente.CAMPO_CONTACTO, contacto)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Clientes {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaBDCliente.CAMPO_NOME)
            val posIdade = cursor.getColumnIndex(TabelaBDCliente.CAMPO_IDADE)
            val posNif = cursor.getColumnIndex(TabelaBDCliente.CAMPO_NIF)
            val posContacto = cursor.getColumnIndex(TabelaBDCliente.CAMPO_CONTACTO)

            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)
            val idade = cursor.getString(posIdade)
            val nif = cursor.getString(posNif)
            val contacto = cursor.getString(posContacto)

            return Clientes(nome, id, idade, nif, contacto)
        }
    }
}