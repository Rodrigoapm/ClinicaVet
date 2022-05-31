package com.example.clinicaveterinaria

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDAnimal (val db: SQLiteDatabase){
    fun cria(){
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_RACA TEXT NOT NULL, $CAMPO_CLIENTE_ID INTEGER NOT NULL, FOREIGN KEY ($CAMPO_NOME) REFERENCES ${TabelaBDNOME.NOME} (${BaseColumns._ID}) ON DELETE RESTRICT)")

    }

    companion object {
        const val NOME = "Animal"
        const val CAMPO_NOME ="NOME"
        const val CAMPO_RACA = "RACA"
        const val CAMPO_CLIENTE_ID = "ClienteID"
    }
}