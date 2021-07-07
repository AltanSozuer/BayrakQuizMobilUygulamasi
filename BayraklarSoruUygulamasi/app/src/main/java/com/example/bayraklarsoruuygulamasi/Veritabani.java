package com.example.bayraklarsoruuygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {
    public Veritabani(@Nullable Context context) {
        super(context, "bayrakdb.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists bayraklar (" +
                "bayrak_id INTEGER PRIMARY KEY," +
                "bayrak_ad TEXT," +
                "bayrak_resim TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists bayraklar");
        onCreate(db);
    }
}