package com.example.am.projektpum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import static android.provider.BlockedNumberContract.BlockedNumbers.COLUMN_ID;

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
    private static final String KEY_WYDARZENIE = "wydarzenie";
    DataBaseHelper(Context context) {
        super(context, "AppDB", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Notatki(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                        "TRESC TEXT);" + "");
        db.execSQL( "create table ListyZakupów(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT ," + "ID_SKLEPU INTEGER,"+
                "PRODUKT TEXT);" + "");
        db.execSQL( "create table Sklepy(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "NAZWA TEXT);" + "");
        db.execSQL( "create table Wydarzenia(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT ," + "ID_TAGU INTEGER," + "DATA STRING,"+
                "OPIS TEXT);" + "");
        db.execSQL( "create table Tagi(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "OPIS TEXT);" + "");}



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + database_table_listy_zakupow);
        db.execSQL("DROP TABLE IF EXISTS " + database_table_notatki);
        db.execSQL("DROP TABLE IF EXISTS " + database_table_sklepy);
        db.execSQL("DROP TABLE IF EXISTS " + database_table_wydarzenia);
        db.execSQL("DROP TABLE IF EXISTS " + database_table_tagi);

        onCreate(db);
    }

    public boolean wstawWydarzenie(String data, String opis) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("DATA", data);
        cv.put("OPIS", opis);

        if (db.insert(database_table_wydarzenia, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }
    public int getEvent(String a) {
        String Query = "SELECT  * FROM " + database_table_notatki+ " WHERE " + "TRESC" + " LIKE " + a;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(Query, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public boolean wstawNotatke(String tresc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TRESC", tresc);

        if (db.insert(database_table_notatki, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean usunWydarzenie(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        if( db.delete(database_table_wydarzenia, "ID=?", new String[]{id })>0)
            return true;
        else return false;
    }
    public boolean usunNotatke(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        if( db.delete(database_table_notatki, "ID=?", new String[]{id })>0)
            return true;
        else return false;
    }
    public SQLiteCursor pobierzWydarzenie(){
        SQLiteDatabase db=this.getWritableDatabase();
        SQLiteCursor kursor= (SQLiteCursor) db.rawQuery("SELECT * FROM " + database_table_wydarzenia, null);
        return kursor;
    }
    public SQLiteCursor pobierzNotatke(){
        SQLiteDatabase db=this.getWritableDatabase();
        SQLiteCursor kursor= (SQLiteCursor) db.rawQuery("SELECT * FROM " + database_table_notatki, null);
        return kursor;
    }


    }
