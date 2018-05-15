package com.example.am.projektpum;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by am on 18.04.2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String database_name = "AppDB";
    public static final String database_table_notatki = "Notatki";
    public static final String database_table_listy_zakupow = "ListyZakupów";
    public static final String database_table_sklepy = "Sklepy";
    public static final String database_table_wydarzenia = "Wydarzenia";
    public static final String database_table_tagi = "Tagi";
    private static final String KEY_NOTES = "notatki";

    DataBaseHelper(Context context) {
        super(context, "CalendarDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table Notatki(" + "ID_Sklepu INTEGER PRIMARY KEY AUTOINCREMENT ," +
                        KEY_NOTES +" TEXT," +
                        "NAZWA INTEGER);" + "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + database_table_listy_zakupow);
        db.execSQL("DROP TABLE IF EXISTS " + database_table_notatki);
        db.execSQL("DROP TABLE IF EXISTS " + database_table_sklepy);
        db.execSQL("DROP TABLE IF EXISTS " + database_table_wydarzenia);
        db.execSQL("DROP TABLE IF EXISTS " + database_table_tagi);

        onCreate(db);
    }

    public boolean wstawWydarzenie(String N, String L) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
//        cv.put(KEY_NOTES, NAPOJ);
//        cv.put("col", col);

        if (db.insert(database_table_wydarzenia, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean wstawNotatke(String N, String L) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
//        cv.put(KEY_NOTES, NAPOJ);
//        cv.put("col", col);

        if (db.insert(database_table_wydarzenia, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean usunRekordy(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        if( db.delete(database_table_wydarzenia, "ID=?", new String[]{id })>0)
            return true;
        else return false;
    }
//    public SQLiteCursor pobierzDane(){
//        SQLiteDatabase db=this.getWritableDatabase();
//        SQLiteCursor kursor= (SQLiteCursor) db.rawQuery("SELECT * FROM " + database_table_wydarzenia, null);
//        return kursor;
//    }
}