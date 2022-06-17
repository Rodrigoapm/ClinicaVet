package com.example.clinicaveterinaria

import android.content.ContentValues

class Animal(
    var Clienteid: Long,
    var nome : String,
    var raca: String,
    var idCliente: Long
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDAnimal.CAMPO_RACA, raca)
        valores.put(TabelaBDAnimal.CAMPO_NOME, nome)
        valores.put(TabelaBDAnimal.CAMPO_CLIENTE_ID, idCliente)

        return valores
    }
}