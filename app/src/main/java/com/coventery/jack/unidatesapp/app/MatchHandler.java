package com.coventery.jack.unidatesapp.app;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 13/04/2016.
 */
public class MatchHandler extends SQLiteOpenHelper

    {

        private static final int DATABASE_VERSION = 1;
        // database name
        private static final String DATABASE_NAME = "MatchHandler";
        // database table name
        private static final String TABLE_CONTENTS = "Matches";

        //table colums
        private static final String KEY_ID = "id";
        private static final String KEY_FIRSTNAME = "firstname";
        private static final String KEY_LASTNAME = "lastname";
        private static final String KEY_AGE = "age";
        private static final String KEY_UNIVERSITY = "university";
        private static final String KEY_URL1 = "url1";
        private static final String KEY_URL2 = "url2";
        private static final String KEY_URL3 = "url3";


        public MatchHandler(Context context, String DATABASE_Addition){
        super(context, DATABASE_NAME + DATABASE_Addition, null, DATABASE_VERSION);
    }

        //CREATEING TABLES

        @Override
        public void onCreate(SQLiteDatabase db){
        Log.d("starting table", " createing table");
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_CONTENTS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_FIRSTNAME + " TEXT," + KEY_LASTNAME + " TEXT," + KEY_AGE  + " TEXT," + KEY_UNIVERSITY + " TEXT,"+
                KEY_URL1 + " TEXT," + KEY_URL2 + " TEXT," + KEY_URL3 + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
        Log.d("ending table", " finished table");
    }

        //updateing
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTENTS);
            Log.d("Database"," exists ");
        onCreate(db);
    }
        //add user
    public void addMatch(Matches matchs)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, matchs._Firstname);
        values.put(KEY_LASTNAME, matchs._Surname);
        values.put(KEY_AGE, matchs._Age);
        values.put(KEY_UNIVERSITY, matchs._University);
        values.put(KEY_URL1, matchs._Url1);
        values.put(KEY_URL2, matchs._Url2);
        values.put(KEY_URL3, matchs._Url3);

        db.insert(TABLE_CONTENTS,null , values);
        db.close();
    }

    public ArrayList<Matches> getAllUsers(){
        ArrayList<Matches> Match = new ArrayList<Matches>();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery ,null);

        if (cursor.moveToFirst()){
            do{
                Matches match = new Matches();
                match.set_id(Integer.parseInt(cursor.getString(0)));
                match.set_Firstname(cursor.getString(1));
                match.set_Surname(cursor.getString(2));
                match.set_Age(cursor.getString(3));
                match.set_University(cursor.getString(4));
                match.set_Url1(cursor.getString(5));
                match.set_Url2(cursor.getString(6));
                match.set_Url3(cursor.getString(7));
                Match.add(match);

            }while (cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return Match;
    }

    // Getting contacts Count
    public long getUserCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TABLE_CONTENTS);
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return count;
    }

}

