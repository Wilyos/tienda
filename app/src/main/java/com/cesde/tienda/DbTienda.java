package com.cesde.tienda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbTienda extends SQLiteOpenHelper {
    public  static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "cesdeShop";
    public DbTienda(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE users (id int primary key AUTOINCREMENT," +
                        "name VARCHAR(50), email VARCHAR(50),"+
                        "identification int, password VARCHAR(16))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }
}
