package com.example.bayraklarsoruuygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BayrakDAO {
    public ArrayList<Bayrak> rastgeleBayraklar(Veritabani vt){
        ArrayList<Bayrak> liste=new ArrayList<>();
        SQLiteDatabase db=vt.getReadableDatabase();
        Cursor cursor=db.rawQuery("select  * from bayraklar order by RANDOM() limit 4",null);
        while(cursor.moveToNext()){
            liste.add(new Bayrak(cursor.getInt(cursor.getColumnIndex("bayrak_id")),
                    cursor.getString(cursor.getColumnIndex("bayrak_ad")),
                    cursor.getString(cursor.getColumnIndex("bayrak_resim"))));
        }
        return liste;
    }
}
