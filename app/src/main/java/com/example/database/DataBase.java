package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;

import java.security.spec.RSAOtherPrimeInfo;

public class DataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "productdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "products";
    private static final String ID_COL = "id";
    private static final String NAME = "name";
    private static final String PRIZE = "prize";
    private static final String DATE = "date";

    public DataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT,"
                + PRIZE + " TEXT,"
                + DATE+ " TEXT)");


        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP TABLE IF EXIST "+ TABLE_NAME));
        onCreate(db);
    }

    public void addProduct(String name, String prize){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        String date = sdf.format(c.getTime());

        values.put(NAME, name);
        values.put(PRIZE, prize);
        values.put(DATE, date);

    }
}
