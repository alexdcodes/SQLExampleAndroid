import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "data.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "data_table"
        const val COLUMN_ID = "id"
        const val COLUMN_TEXT = "text"
        const val COLUMN_TIMESTAMP = "timestamp"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEXT + " TEXT, " +
                COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(text: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_TEXT, text)
        }
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }
}
