package com.example.clinicaveterinaria


import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import java.lang.ref.Reference


class TabelaBDAnimal (val db: SQLiteDatabase){
    fun cria(){
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_RACA TEXT NOT NULL, $CAMPO_CLIENTE_ID INTEGER NOT NULL REFERENCES ${TabelaBDCliente},$CAMPO_ANIMAL_ID INTEGER NOT NULL, FOREIGN KEY ($CAMPO_NOME), (${BaseColumns._ID}) ON DELETE RESTRICT)")

    }

    companion object {
        const val NOME = "Animal"
        const val CAMPO_ANIMAL_ID = "ANIMALID"
        const val CAMPO_NOME ="NOME"
        const val CAMPO_RACA = "RACA"
        const val CAMPO_CLIENTE_ID = "CLIENTEID"
    }
    val TODAS_COLUNAS = arrayOf( CAMPO_RACA, CAMPO_NOME, CAMPO_CLIENTE_ID, TabelaBDCliente.CAMPO_NOME)
}