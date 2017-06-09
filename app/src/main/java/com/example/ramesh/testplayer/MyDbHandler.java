package com.example.ramesh.testplayer;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ramesh on 03-06-2017.
 */

public class MyDbHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME="RegisteredUsers.db";
    public static final String TABLE_USERS="RegisteredUsers";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_Username="Username";
    public static final String COLUMN_Password="Password";

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query ="INSERT TABLE "+TABLE_USERS+"("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_Username+ " TEXT " +
                COLUMN_Password+ " TEXT " +
                ");";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_USERS);
        onCreate(db);
    }
    //add a user to table
    public void addUser(RegisterForm RegisterForm){
        ContentValues values = new ContentValues();
        values.put(COLUMN_Username,RegisterForm.getUserName());
        values.put(COLUMN_Password,RegisterForm.getPassword());
        SQLiteDatabase db = getWritableDatabase();
                db.insert(TABLE_USERS,null,values);
        db.close();

    }
    //delete user from table
    public void DeleteUser(String username){
       SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_USERS+" WHERE "+COLUMN_Username+"=\""+username+"\"" );
        db.close();
    }
    //Admin can view list of users and manage
    public String viewusers(){
        String viewdata = " ";
        SQLiteDatabase db = getReadableDatabase();
        String Query = "SELECT * FROM "+TABLE_USERS+" WHERE 1";
        Cursor c=db.rawQuery(Query, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("username"))!=null){
                viewdata += c.getString(c.getColumnIndex("username"));
                viewdata += "\n";
            }
        }
        db.close();
        return viewdata;
    }


}
