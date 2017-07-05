package com.example.ramesh.testplayer

import android.app.DownloadManager
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.util.Log

/**
 * Created by Ramesh on 03-06-2017.
 */

class MyDbHandler(context: Context, name: String, factory: SQLiteDatabase.CursorFactory, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE " + TABLE_USERS + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMN_Username + " TEXT , " +
                COLUMN_Password + " TEXT " +
                " );"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) db.validateSql(query, null)
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS)
        onCreate(db)
    }

    //add a user to table
    fun addUser(RegisterForm: RegisterForm) {
        val values = ContentValues()
        values.put(COLUMN_Username, RegisterForm.userName)
        values.put(COLUMN_Password, RegisterForm.password)
        val db = writableDatabase
        db.insert(TABLE_USERS, null, values)
        db.close()

    }

    //delete user from table
    fun DeleteUser(username: String) {
        val db = writableDatabase
        db.execSQL("DELETE FROM $TABLE_USERS WHERE $COLUMN_Username=\"$username\"")
        db.close()
    }

    //Admin can view list of users and manage
    fun viewusers(): String {
        var viewdata = " "
        val db = writableDatabase
        val query = "SELECT * FROM " + TABLE_USERS
        val c = db.rawQuery(query, null)
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
        c!!.moveToFirst()
        /* while(c.isAfterLast()){
             if(c.getString(c.getColumnIndex("_id"))!=null){
                viewdata += c.getString(c.getColumnIndex("Username"));
                viewdata += "\n";
            }
        }*/

        //c.moveToFirst();

        if (c == null) {
            return "Empty"
        } else
            viewdata = " Username    " + " Password  \n"
        do {
            for (i in 0..c.columnCount - 1) {

                Log.e("test", " data " + c.getString(i))
            }
            viewdata += c.getString(c.getColumnIndex("Username")) + "      " + c.getString(c.getColumnIndex("Password"))
            viewdata += "\n"
        } while (c.moveToNext())

        //    }
        db.close()
        return viewdata
    }

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "RegisteredUsers.db"
        val TABLE_USERS = "RegisteredUsers"
        val COLUMN_ID = "_id"
        val COLUMN_Username = "Username"
        val COLUMN_Password = "Password"
    }


}
