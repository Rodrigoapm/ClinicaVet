package com.example.clinicaveterinaria

import android.content.ContentValues

class Animal(
    var id: Long,
    var titulo : String,
    var autor: String,
    var idCategoria: Long
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDAnimal.CAMPO_RACA, RACA)
        valores.put(TabelaBDAnimal.CAMPO_NOME, NOME)
        valores.put(TabelaBDAnimal.CAMPO_CLIENTE_ID, IDCLIENTE)

        return valores
    }
}