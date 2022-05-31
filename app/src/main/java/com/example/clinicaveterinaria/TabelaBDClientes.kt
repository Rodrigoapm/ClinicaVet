package com.example.clinicaveterinaria

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDClientes (db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME TEXT NOT NULL, $CAMPO_CLIENTES_ID INTEGER NOT NULL, FOREIGN KEY ($CAMPO_CLIENTES_ID) REFERENCES ${TabelaBDClientes.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object {
        const val NOME = "Clientes"
        const val CAMPO_NOME = "NOME"
        const val CAMPO_CLIENTES_ID = "CLIENTEID"
    }
}