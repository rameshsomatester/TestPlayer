package com.example.ramesh.testplayer;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

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
        String query ="CREATE TABLE "+TABLE_USERS+" ( "+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMN_Username+ " TEXT , " +
                COLUMN_Password+ " TEXT " +
                " );";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) db.validateSql(query,null);
        db.execSQL(query);
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
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_USERS;
        Cursor c=db.rawQuery(query, null);
     /*   if(c.moveToFirst()) {
            Log.d("DbHandler", " count" + c.getCount() + " " + c.getColumnName(0));
            Log.d("DbHandler", " column name" + c.getString(c.getColumnIndex("_id")));
            for(int i =0 ;i<c.getColumnNames().length;i++){
                Log.d("DbHandler"," columnames "+i+ " "+c.getColumnName(i));
            }

            if (c.getString(c.getColumnIndex("Username")) != null) {
                viewdata += c.getString(c.getColumnIndex("Username"));
                viewdata += "\n";

            }
        }*/
        //Log.d("DbHandler", " viewData" + viewdata);
      c.moveToFirst();
       /* while(c.isAfterLast()){
             if(c.getString(c.getColumnIndex("_id"))!=null){
                viewdata += c.getString(c.getColumnIndex("Username"));
                viewdata += "\n";
            }
        }*/

        //c.moveToFirst();

        if (c == null || c.isAfterLast()) {
            return "Empty";
        }
        else {
            if (c.moveToFirst()) {
                while (!c.isAfterLast()) {
                    viewdata = " Username    " + " Password  \n";
                    viewdata += c.getString(c.getColumnIndex("Username")) + "      " + c.getString(c.getColumnIndex("Password"));
                    viewdata += "\n";
                    c.moveToNext();
                }
            }
                c.close();
                db.close();
            return viewdata;
        }
    }


}
