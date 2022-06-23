package com.example.clinicaveterinaria

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDCliente (val db: SQLiteDatabase){
    fun cria(){
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_IDADE TEXT NOT NULL, $CAMPO_CONTACTO TEXT NOT NULL, $CAMPO_NIF TEXT NOT NULL, $CAMPO_CLIENTE_ID INTEGER NOT NULL, FOREIGN KEY ($CAMPO_NOME) REFERENCES ${TabelaBDCliente.NOME} (${BaseColumns._ID}) ON DELETE RESTRICT)")

    }

    companion object {
        const val NOME = "Animal"
        const val CAMPO_NOME ="nome"
        const val CAMPO_IDADE = "idade"
        const val CAMPO_CONTACTO = "contacto"
        const val CAMPO_NIF = "nif"
        const val CAMPO_CLIENTE_ID = "CLIENTEID"
    }
}