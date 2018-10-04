package com.example.duvan.peluchitosapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PeluchesSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE peluches (" +
            "codigo     INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre     TEXT, " +
            "cantidad   INTEGER, " +
            "precio     INTEGER)";

    public PeluchesSQLiteHelper(Context context,
                                String name,
                                SQLiteDatabase.CursorFactory factory,
                                int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //CREAR BASE DE DATOS
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //ACTUALIZAR BASE DE DATOS
        db.execSQL("DROP TABLE IF EXISTS peluches");
        db.execSQL(sqlCreate);
    }
}
