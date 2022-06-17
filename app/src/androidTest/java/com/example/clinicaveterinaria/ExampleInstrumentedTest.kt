package com.example.clinicaveterinaria

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BaseDadosTest {
    private fun appContext() =
        InstrumentationRegistry.getInstrumentation().targetContext

    private fun getWritableDatabase(): SQLiteDatabase {
        val openHelper = BDclinicaOpenHelper(appContext())
        return openHelper.writableDatabase
    }

    private fun insereClientes(db: SQLiteDatabase, clientes: Clientes) {
        clientes.id = TabelaBDClientes(db).insert(clientes.toContentValues())
        assertNotEquals(-1, clientes.id)
    }

    private fun insereAnimal(db: SQLiteDatabase, animal: Animal) {
        animal.id = TabelaBDAnimal(db).insert(animal.toContentValues())
        assertNotEquals(-1, animal.id)
    }

    @Before
    fun apagaBaseDados() {
        appContext().deleteDatabase(BDCliinicaOpenHelper.NOME)
    }

    @Test
    fun consegueAbrirBaseDados() {
        val openHelper = BDclinicaOpenHelper(appContext())
        val db = openHelper.readableDatabase

        assertTrue(db.isOpen)

        db.close()
    }

    @Test
    fun consegueInserirClientes() {
        val db = getWritableDatabase()

        insereClientes(db, Clientes("Nome"))

        db.close()
    }

    @Test
    fun consegueInserirAnimal() {
        val db = getWritableDatabase()

        val RACA = RACA("Cão Serra da Estrela")
        insereCliente(db, cliente)

        val livro = Livro("O Leão que Temos Cá Dentro", "Rachel Bright", categoria.id)
        insereLivro(db, livro)

        db.close()
    }

    @Test
    fun consegueAlterarCategoria() {
        val db = getWritableDatabase()

        val categoria = Categoria("Teste")
        insereCategoria(db, categoria)

        categoria.nome = "Ficção científica"

        val registosAlterados = TabelaBDCategorias(db).update(
            categoria.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${categoria.id}"))

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarLivros() {
        val db = getWritableDatabase()

        val categoriaSuspense = Categoria("Suspense")
        insereCategoria(db, categoriaSuspense)

        val categoriaMisterio = Categoria("Mistério")
        insereCategoria(db, categoriaMisterio)

        val livro = Livro("Teste", "Teste", categoriaSuspense.id)
        insereLivro(db, livro)

        livro.titulo = "A rapariga no comboio"
        livro.autor = "Paula Hawkins"
        livro.idCategoria = categoriaMisterio.id

        val registosAlterados = TabelaBDLivros(db).update(
            livro.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${livro.id}"))

        assertEquals(1, registosAlterados)

        db.close()
    }