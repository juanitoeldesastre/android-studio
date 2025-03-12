package com.example.minterfaz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UsuariosDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "usuarios";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT)";
        db.execSQL(CREATE_TABLE);

        // Insertar datos de prueba
        db.execSQL("INSERT INTO " + TABLE_NAME + " (nombre) VALUES ('Juan')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (nombre) VALUES ('María')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (nombre) VALUES ('Carlos')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Método para obtener todos los usuarios
    public Cursor getUsuarios() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
