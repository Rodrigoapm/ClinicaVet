import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.clinicaveterinaria.*
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
class BaseDadosTest{
private fun appContext() =
    InstrumentationRegistry.getInstrumentation().targetContext

private fun getWritableDatabase(): SQLiteDatabase {
    val openHelper = BDclinicaOpenHelper(appContext())
    return openHelper.writableDatabase
}

private fun insereClientes(db: SQLiteDatabase, cliente: Clientes) {
    cliente.id = TabelaBDCliente(db).insert(cliente.toContentValues())
    assertNotEquals(-1, cliente.id)
}

private fun insereAnimal(db: SQLiteDatabase, Animal: Animal) {
    Animal.id = TabelaBDAnimal(db).insert(Animal.toContentValues())
    assertNotEquals(-1, Animal.id)
}

@Before
fun apagaBaseDados() {
    appContext().deleteDatabase(BDclinicaOpenHelper.NOME)
}

@Test
fun consegueAbrirBaseDados() {
    val openHelper = BDclinicaOpenHelper(appContext())
    val db = openHelper.readableDatabase

    assertTrue(db.isOpen)

    db.close()
}

@Test
fun consegueInserirCliente() {
    val db = getWritableDatabase()

    insereClientes(db, Clientes("Rodrigo Martins "))

    db.close()
}


fun consegueInserirCarro() {
    val db = getWritableDatabase()

    val Cliente = Clientes("Rodrigo Martins")
    insereClientes(db, Cliente )

    val Carro = Animal("Boby", "Pastor alemão", "1","1")
    insereClientes(db, Cliente);

    db.close()
}



@Test
fun consegueAlterarCliente() {
    val db = getWritableDatabase()

    val cliente = Clientes("Teste")
    insereClientes(db, cliente)

    cliente.nome = "Rodrigo Pires"

    val registosAlterados = TabelaBDCliente(db).update(
        cliente.toContentValues(),
        "${BaseColumns._ID}=?",
        arrayOf("${cliente.id}"))

    assertEquals(1, registosAlterados)

    db.close()
}
@Test
fun consegueEliminarCliente() {
    val db = getWritableDatabase()

    val Cliente = Cliente("Rui Condess")
    insereClientes(db, Cliente)

    val registosEliminados = TabelaBDCliente(db).delete(
        "${BaseColumns._ID}=?",
        arrayOf("${Cliente.id}"))

    assertEquals(1, registosEliminados)

    db.close()
}
@Test
fun consegueEliminarClientes() {
    val db = getWritableDatabase()

    val Clientes = Clientes("Rodrigo Martins", "24, nif: 123456789")
    insereClientes(db, Clientes)

    val registosEliminados = TabelaBDCliente(db).delete(
        "${BaseColumns._ID}=?",
        arrayOf("${Clientes.id}"))

    assertEquals(1, registosEliminados)

    db.close()
}
@Test
fun consegueLerClientes() {
    val db = getWritableDatabase()

    val cliente = Clientes("Rodrigo Martins")
    insereClientes(db, cliente  )

    val cursor = TabelaBDCliente(db).query(
        TabelaBDCliente.TODAS_COLUNAS,
        "${BaseColumns._ID}=?",
        arrayOf("${cliente.id}"),
        null,
        null,
        null
    )

    assertEquals(1, cursor.count)
    assertTrue(cursor.moveToNext())

    val clienteBD = Clientes.fromCursor(cursor)

    assertEquals(cliente, clienteBD)

    db.close()
}



}