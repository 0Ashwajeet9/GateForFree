package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="register.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="username";
    public static final String COL_3 ="password";
    public static final String COL_4="emailid";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser(ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT,emailid TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS registeruser" );
        onCreate(sqLiteDatabase);

    }
    public long adduser(String user,String password,String emailid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        contentValues.put("emailid",emailid);
        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return res;

    }
    public boolean checkuser(String username,String password )
    {
        String[] columns={COL_1 };
        SQLiteDatabase db=getReadableDatabase();
        String selection=COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs={ username , password };
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
            return true;
        else
            return false;

    }
    public String sendemail(String username,String password,String emailid)
    {
        SQLiteDatabase db=getReadableDatabase();
        String projection[]={"username","password","emailid",};
        Cursor c=db.query(TABLE_NAME,projection,null,null,null,null,null);
        c.moveToLast();
        String em=c.getString(2);
        return em;
    }
}
