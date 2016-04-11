package com.coventery.jack.unidatesapp.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 07/04/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    // database name
    private static final String DATABASE_NAME = "UsersManager";
    // database table name
    private static final String TABLE_CONTENTS = "Users";

    //table colums
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_FIRSTNAME = "firstname";
    private static final String KEY_LASTNAME = "lastname";
    private static final String KEY_AGE = "age";
    private static final String KEY_UNIVERSITY = "university";
    private static final String KEY_URL1 = "url1";
    private static final String KEY_URL2 = "url2";
    private static final String KEY_URL3 = "url3";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //CREATEING TABLES

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.d("starting table"," createing table");
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_CONTENTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERNAME + " TEXT," +
                KEY_PASSWORD + " TEXT," + KEY_FIRSTNAME + " TEXT," + KEY_LASTNAME + " TEXT," + KEY_AGE  + " TEXT," + KEY_UNIVERSITY + " TEXT,"+
                KEY_URL1 + " TEXT," + KEY_URL2 + " TEXT," + KEY_URL3 + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
        Log.d("ending table", " finished table");
    }

    //updateing
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTENTS);
        onCreate(db);
    }
    //add user
    public void addUser(Users users)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, users._Username);
        values.put(KEY_PASSWORD, users._Password);
        values.put(KEY_FIRSTNAME, users._Firstname);
        values.put(KEY_LASTNAME, users._Surname);
        values.put(KEY_AGE, users._Age);
        values.put(KEY_UNIVERSITY, users._University);
        values.put(KEY_URL1, users._Url1);
        values.put(KEY_URL2, users._Url2);
        values.put(KEY_URL3, users._Url3);

        db.insert(TABLE_CONTENTS,null , values);
        db.close();
    }

    public ArrayList<Users> getAllUsers(){
        ArrayList<Users> users = new ArrayList<Users>();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery ,null);

        if (cursor.moveToFirst()){
            do{
                Users user = new Users();
                user.set_id(Integer.parseInt(cursor.getString(0)));
                user.set_Username(cursor.getString(1));
                user.set_Password(cursor.getString(2));
                user.set_Firstname(cursor.getString(3));
                user.set_Surname(cursor.getString(4));
                user.set_Age(Integer.parseInt(cursor.getString(5)));
                user.set_University(cursor.getString(6));
                user.set_Url1(cursor.getString(7));
                user.set_Url2(cursor.getString(8));
                user.set_Url3(cursor.getString(9));

                users.add(user);
            }while (cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return users;
    }

    // Getting contacts Count
    public long getUserCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db,TABLE_CONTENTS);
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return count;
    }

}
